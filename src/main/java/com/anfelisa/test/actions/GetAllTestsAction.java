package com.anfelisa.test.actions;

import javax.annotation.security.RolesAllowed;
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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.test.data.SimpleTestListData;
import com.anfelisa.test.models.CustomTestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllTestsAction extends AbstractGetAllTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllTestsAction.class);

	private CustomTestDao customTestDao = new CustomTestDao();

	public GetAllTestsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/all")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("lessonId") String lessonId)
			throws JsonProcessingException {
		this.actionData = new SimpleTestListData(uuid).withLessonId(lessonId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		this.actionData.setTestList(customTestDao.selectTests(getHandle(), actionData.getLessonId()));
	}

}

/* S.D.G. */
