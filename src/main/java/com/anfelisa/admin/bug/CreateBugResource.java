package com.anfelisa.admin.bug;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/bug")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateBugResource {
	static final Logger LOG = LoggerFactory.getLogger(CreateBugResource.class);

	private DBI jdbi;

	private BugDao bugDao = new BugDao();

	public CreateBugResource(DBI jdbi) {
		super();
		this.jdbi = jdbi;
	}

	@POST
	@Timed
	@Path("/create")
	// We might want to protect this resource!
	public Response post(@NotNull BugModel data) throws JsonProcessingException {
		Handle handle = jdbi.open();
		try {
			data.setCreatedDateTime(new DateTime());
			data.setResolved(false);
			Integer id = bugDao.insert(handle, data);
			return Response.ok(id).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		} finally {
			handle.close();
		}
	}

}

/* S.D.G. */
