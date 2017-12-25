package com.anfelisa;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.AceDao;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScoredCardDao;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.StudentOfCourseDao;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;
import com.anfelisa.user.models.UserModel;
import com.codahale.metrics.annotation.Timed;

@Path("/database")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ClearDatabaseResource {

	private DBI jdbi;

	private AceDao aceDao = new AceDao();

	private BoxDao boxDao = new BoxDao();
	private BoxOfCourseDao boxOfCourseDao = new BoxOfCourseDao();
	private CardDao cardDao = new CardDao();
	private CourseDao courseDao = new CourseDao();
	private LessonDao lessonDao = new LessonDao();
	private LoginLogDao loginLogDao = new LoginLogDao();
	private ResultDao resultDao = new ResultDao();
	private ScheduledCardDao scheduledCardDao = new ScheduledCardDao();
	private ScoredCardDao scoredCardDao = new ScoredCardDao();
	private StudentOfCourseDao studentOfCourseDao = new StudentOfCourseDao();
	private TestDao testDao = new TestDao();
	private UserDao userDao = new UserDao();

	public ClearDatabaseResource(DBI jdbi) {
		super();
		this.jdbi = jdbi;
	}

	@DELETE
	@Timed
	@Path("/reset")
	public Response put() {
		Handle handle = jdbi.open();
		try {
			resultDao.truncate(handle);
			scoredCardDao.truncate(handle);
			scheduledCardDao.truncate(handle);
			cardDao.truncate(handle);
			loginLogDao.truncate(handle);
			studentOfCourseDao.truncate(handle);
			testDao.truncate(handle);
			boxOfCourseDao.truncate(handle);
			boxDao.truncate(handle);
			lessonDao.truncate(handle);
			courseDao.truncate(handle);
			userDao.truncate(handle);

			userDao.insert(handle, new UserModel("Annette", "ddb4524e162d7d44c09903f7e2943cf1", "Pohl", "Annette",
					"annette_pohl@web.de", "ADMIN", true));

			aceDao.truncateErrorTimelineTable(handle);
			aceDao.truncateTimelineTable(handle);

			return Response.ok().build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		} finally {
			handle.close();
		}
	}

}
