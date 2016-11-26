package com.anfelisa.course.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.actions.LoadStatisticsAction;
import com.anfelisa.course.data.StatisticsData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadStatisticsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadStatisticsResource.class);

	public LoadStatisticsResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("year") Integer year,
			@NotNull @QueryParam("month") Integer month) throws JsonProcessingException {
		StatisticsData actionParam = new StatisticsData(user.getUsername(), year, month, uuid, schema);
		return new LoadStatisticsAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/* S.D.G. */
