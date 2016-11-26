package com.anfelisa.lesson.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Resource;
import com.anfelisa.lesson.actions.LoadPrivateLessonsAction;
import com.anfelisa.lesson.data.LessonListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateLessonsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsResource.class);

	public LoadPrivateLessonsResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll // set permission
	public Response get(/* params here */) throws JsonProcessingException {
		LessonListData actionParam = null;  // init actionParam
		return new LoadPrivateLessonsAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
