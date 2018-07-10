package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxInfoData;
import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/box")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetBoxAction extends AbstractGetBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxAction.class);

	public GetBoxAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/get")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") String boxId, @NotNull @QueryParam("today") String today)
			throws JsonProcessingException {
		DateTime todayDate = new DateTime(today);
		todayDate = todayDate.withZone(DateTimeZone.UTC);
		this.actionData = new BoxInfoData(uuid).withBoxId(boxId).withToday(todayDate).withUserId(user.getUserId());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), actionData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(actionData.getUserId())) {
			throwUnauthorized();
		}
		IBoxInfoModel boxInfo = daoProvider.getCustomBoxDao().selectByBoxId(getHandle(), actionData.getBoxId(),
				actionData.getToday());
		this.actionData.setCategoryId(boxInfo.getCategoryId());
		this.actionData.setCategoryIndex(boxInfo.getCategoryIndex());
		this.actionData.setCategoryName(boxInfo.getCategoryName());
		this.actionData.setDaysBehindSchedule(boxInfo.getDaysBehindSchedule());
		this.actionData.setMaxInterval(boxInfo.getMaxInterval());
		this.actionData.setMyCards(boxInfo.getMyCards());
		this.actionData.setTodaysCards(boxInfo.getTodaysCards());
		this.actionData.setTotalCards(boxInfo.getTotalCards());
		this.actionData.setReinforceCards(boxInfo.getReinforceCards());
		this.actionData.setQuality0Count(boxInfo.getQuality0Count());
		this.actionData.setQuality1Count(boxInfo.getQuality1Count());
		this.actionData.setQuality2Count(boxInfo.getQuality2Count());
		this.actionData.setQuality3Count(boxInfo.getQuality3Count());
		this.actionData.setQuality4Count(boxInfo.getQuality4Count());
		this.actionData.setQuality5Count(boxInfo.getQuality5Count());
	}

}

/* S.D.G. */
