package com.anfelisa.course.actions;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.data.StatisticsData;
import com.anfelisa.course.models.CustomStatisticsDao;
import com.anfelisa.course.models.IStatisticsItemModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadStatisticsAction extends AbstractLoadStatisticsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadStatisticsAction.class);

	private CustomStatisticsDao customStatisticsDao = new CustomStatisticsDao();

	public LoadStatisticsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("year") Integer year,
			@NotNull @QueryParam("month") Integer month) throws JsonProcessingException {
		this.actionData = new StatisticsData(uuid, schema).withUsername(user.getUsername()).withMonth(month)
				.withYear(year);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		DateTime startDate = new DateTime(this.actionData.getYear(), this.actionData.getMonth(), 1, 0, 0, 0);
		DateTime endDate = startDate.plusMonths(1);
		List<IStatisticsItemModel> itemList = customStatisticsDao.selectStatistics(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername(), startDate, endDate, this.actionData.getSchema());
		this.actionData.setStatisticsItemList(itemList);
		int points = 0;
		int maxPoints = 0;
		for (IStatisticsItemModel item : itemList) {
			points += item.getPoints();
			maxPoints += item.getMaxPoints();
		}
		this.actionData.setMaxPoints(maxPoints);
		this.actionData.setPoints(points);
		if (maxPoints > 0) {
			this.actionData.setRate(points * 100 / maxPoints);
		}
	}

}

/* S.D.G. */
