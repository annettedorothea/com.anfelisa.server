package com.anfelisa.lesson.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.lesson.actions.UpdateLessonAction;
import com.anfelisa.lesson.data.LessonData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateLessonResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UpdateLessonResource.class);

	public UpdateLessonResource( DBI jdbi ) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response put(@NotNull LessonData data) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		return new UpdateLessonAction(data, handle).apply();
	}

}

/*       S.D.G.       */
