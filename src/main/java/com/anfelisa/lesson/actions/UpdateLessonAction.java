package com.anfelisa.lesson.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.lesson.data.LessonData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UpdateLessonAction extends AbstractUpdateLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateLessonAction.class);

	public UpdateLessonAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
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

/* S.D.G. */
