package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.PointsData;
import com.anfelisa.user.models.CustomUserDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetPointsAction extends AbstractGetPointsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetPointsAction.class);

	private CustomUserDao customUserDao = new CustomUserDao();

	public GetPointsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/points")
	@PermitAll
	public Response get(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		this.actionData = new PointsData(uuid, schema).withUsername(principal.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		int boxPoints = customUserDao.selectBoxPoints(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername(), this.actionData.getSchema());
		int testPoints = customUserDao.selectTestPoints(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername(), this.actionData.getSchema());
		this.actionData.setPoints(boxPoints + testPoints);
	}

}

/* S.D.G. */
