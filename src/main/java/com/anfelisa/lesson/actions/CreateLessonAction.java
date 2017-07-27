package com.anfelisa.lesson.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.lesson.data.LessonCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CreateLessonAction extends AbstractCreateLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateLessonAction.class);

	public CreateLessonAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@POST
	@Timed
	@Path("/create")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response post(@NotNull LessonCreationData lessonCreationData) throws JsonProcessingException {
		this.actionData = lessonCreationData;
		return this.apply();
	}

}

/* S.D.G. */
