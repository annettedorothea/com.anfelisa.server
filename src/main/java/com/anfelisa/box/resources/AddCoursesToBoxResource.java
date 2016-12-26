package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.box.actions.AddCoursesToBoxAction;
import com.anfelisa.box.data.BoxOfCourseListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddCoursesToBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesToBoxResource.class);

	public AddCoursesToBoxResource( DBI jdbi ) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/addcourses")
	@PermitAll // set permission
	public Response put(/* params here */) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		BoxOfCourseListData actionParam = null;  // init actionParam
		return new AddCoursesToBoxAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */
