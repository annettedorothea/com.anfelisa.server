package com.anfelisa.lesson.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.lesson.actions.CreateLessonAction;
import com.anfelisa.lesson.data.LessonCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateLessonResource {

	static final Logger LOG = LoggerFactory.getLogger(CreateLessonResource.class);

	@POST
	@Timed
	@Path("/create")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response post(@NotNull LessonCreationData lessonCreationData) throws JsonProcessingException {
		return new CreateLessonAction(lessonCreationData, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
