package com.anfelisa.test.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
import com.anfelisa.test.actions.UpdateTestAction;
import com.anfelisa.test.data.TestCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateTestResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UpdateTestResource.class);

	public UpdateTestResource( DBI jdbi ) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response put(@NotNull TestCreationData testData) throws JsonProcessingException, UnsupportedEncodingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		String decodedHtml = URLDecoder.decode( testData.getHtml(), "UTF-8" );
		testData.setHtml(decodedHtml);
		return new UpdateTestAction(testData, handle).apply();
	}

}

/*       S.D.G.       */
