package com.anfelisa.box.actions;

import java.util.List;

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
import com.anfelisa.box.data.BoxListData;
import com.anfelisa.box.models.IBoxInfoModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/my")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("today") String today) throws JsonProcessingException {
		DateTime todayDate = new DateTime(today);
		todayDate = todayDate.withZone(DateTimeZone.UTC);
		this.actionData = new BoxListData(uuid).withUserId(user.getUserId()).withToday(todayDate);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<IBoxInfoModel> boxList = this.daoProvider.getCustomBoxDao().selectByUserId(
				this.getDatabaseHandle().getHandle(), this.actionData.getUserId(), actionData.getSystemTime());
		this.actionData.setBoxList(boxList);
	}

}

/* S.D.G. */