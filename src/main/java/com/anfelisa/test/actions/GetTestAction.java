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
import com.anfelisa.test.data.TestCreationData;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetTestAction extends AbstractGetTestAction {

	static final Logger LOG = LoggerFactory.getLogger(GetTestAction.class);

	private TestDao testDao = new TestDao();

	public GetTestAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("testId") Integer testId)
			throws JsonProcessingException {
		this.actionData = new TestCreationData(uuid).withTestId(testId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ITestModel test = testDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getTestId());
		if (test != null) {
			this.actionData.setAuthor(test.getAuthor());
			this.actionData.setHtml(test.getHtml());
			this.actionData.setLessonId(test.getLessonId());
			this.actionData.setName(test.getName());
			this.actionData.setSequence(test.getSequence());
		}
	}

}

/* S.D.G. */
