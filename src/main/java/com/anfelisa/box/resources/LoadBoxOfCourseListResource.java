package com.anfelisa.box.resources;

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

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.LoadBoxOfCourseListAction;
import com.anfelisa.box.data.BoxOfCourseListData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadBoxOfCourseListResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxOfCourseListResource.class);

	public LoadBoxOfCourseListResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/courses")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("boxId") Integer boxId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		IBoxModel box = BoxDao.selectByBoxId(handle.getHandle(), boxId, schema);
		if (!box.getUsername().equals(user.getUsername())) {
			handle.close();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		BoxOfCourseListData actionParam = new BoxOfCourseListData(uuid, schema).withUsername(user.getUsername()).withBoxId(boxId);
		return new LoadBoxOfCourseListAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */
