package com.anfelisa.ace;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.box.models.ScoredCardDao;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.StudentOfCourseDao;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.models.SchemaDao;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;

public class PrepareE2EResource extends AbstractPrepareE2EResource{

	private SchemaDao schemaDao = new SchemaDao();
	
	private UserDao userDao = new UserDao();

	private CourseDao courseDao = new CourseDao();

	private LessonDao lessonDao = new LessonDao();

	private TestDao testDao = new TestDao();

	private ResultDao resultDao = new ResultDao();

	private StudentOfCourseDao studentOfCourseDao = new StudentOfCourseDao();

	private BoxDao boxDao = new BoxDao();

	private CardDao cardDao = new CardDao();

	private BoxOfCourseDao boxOfCourseDao = new BoxOfCourseDao();

	private ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	private ScoredCardDao scoredCardDao = new ScoredCardDao();

	private LoginLogDao loginLogDao = new LoginLogDao();

	private AceDao aceDao = new AceDao();

	private Handle handle;

	public PrepareE2EResource(DBI jdbi) {
		super(jdbi);
		this.handle = this.getJdbi().open();
	}

	@Override
	protected void dropSchema(String schema) {
		schemaDao.dropSchema(handle, Constants.replaySchema(schema));
	}

	@Override
	protected void createSchema(String schema) {
		schemaDao.createSchema(handle, Constants.replaySchema(schema));
	}

	@Override
	protected void createTables(String schema) {
		aceDao.createTimelineTable(handle, Constants.replaySchema(schema));
		aceDao.createErrorTimelineTable(handle, Constants.replaySchema(schema));
		userDao.create(handle, Constants.replaySchema(schema));
		courseDao.create(handle, Constants.replaySchema(schema));
		lessonDao.create(handle, Constants.replaySchema(schema));
		testDao.create(handle, Constants.replaySchema(schema));
		resultDao.create(handle, Constants.replaySchema(schema));
		studentOfCourseDao.create(handle, Constants.replaySchema(schema));
		boxDao.create(handle, Constants.replaySchema(schema));
		cardDao.create(handle, Constants.replaySchema(schema));
		scheduledCardDao.create(handle, Constants.replaySchema(schema));
		scoredCardDao.create(handle, Constants.replaySchema(schema));
		boxOfCourseDao.create(handle, Constants.replaySchema(schema));
		loginLogDao.create(handle, Constants.replaySchema(schema));
	}

	@Override
	protected IAction getNextAction(String uuidOfLastAction, String uuidOfE2EStartAction) {
		// TODO Auto-generated method stub
		return null;
	}

}
