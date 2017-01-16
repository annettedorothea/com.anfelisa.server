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

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxIdData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadBoxAction extends AbstractLoadBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxAction.class);

	private BoxDao boxDao = new BoxDao();

	public LoadBoxAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("boxId") Integer boxId)
			throws JsonProcessingException {
		this.actionData = new BoxIdData(uuid, schema).withBoxId(boxId).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername());
		return this.apply();
	}

	@Override
	protected void loadDataForGetRequest() {
		IBoxModel box = boxDao.selectByBoxId(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(),
				this.actionData.getSchema());
		if (!box.getUsername().equals(actionData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.actionData.setName(box.getName());
		this.actionData.setUsername(box.getUsername());
	}

}

/* S.D.G. */
