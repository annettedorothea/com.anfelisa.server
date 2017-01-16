package com.anfelisa.result.actions;

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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.result.data.MyResultData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadResultAction extends AbstractLoadResultAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadResultAction.class);

	private ResultDao resultDao = new ResultDao();

	private CustomLessonDao customLessonDao = new CustomLessonDao();

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	private TestDao testDao = new TestDao();

	private CustomTestDao customTestDao = new CustomTestDao();

	public LoadResultAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("resultId") Integer resultId)
			throws JsonProcessingException {
		this.actionData = new MyResultData(uuid, schema).withResultId(resultId).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IResultModel result = resultDao.selectByResultId(this.getHandle(), actionData.getResultId(),
				actionData.getSchema());
		if (result == null) {
			throwBadRequest();
		}
		if (!result.getUsername().equals(actionData.getUsername())) {
			throwUnauthorized();
		}
		this.actionData.setDate(result.getDate());
		this.actionData.setJson(result.getJson());
		this.actionData.setMaxPoints(result.getMaxPoints());
		this.actionData.setPoints(result.getPoints());
		this.actionData.setTestId(result.getTestId());
		ILessonModel lesson = customLessonDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId(), this.getActionData().getSchema());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		this.actionData.setLessonId(lesson.getLessonId());
		ICourseModel course = customCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				lesson.getLessonId(), this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		ITestModel test = testDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getTestId(),
				this.getActionData().getSchema());
		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setName(test.getName());
		this.actionData.setMyTestList(customTestDao.selectMyTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionData.getLessonId(), this.actionData.getUsername()));
	}

}

/* S.D.G. */
