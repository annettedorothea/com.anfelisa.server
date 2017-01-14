package com.anfelisa.lesson.actions;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.skife.jdbi.v2.DBI;

import com.anfelisa.lesson.data.LessonData;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class UpdateLessonAction extends AbstractUpdateLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateLessonAction.class);

	public UpdateLessonAction(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response put(@NotNull LessonData data) throws JsonProcessingException {
		this.actionData = data;
		return this.apply();
	}


}

/*       S.D.G.       */
