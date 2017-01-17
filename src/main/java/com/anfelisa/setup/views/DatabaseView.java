package com.anfelisa.setup.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.AceDao;
import com.anfelisa.auth.AuthUser;
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
import com.anfelisa.setup.data.SchemaCreationData;
import com.anfelisa.setup.data.SetupSchemaData;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;
import com.anfelisa.user.models.UserModel;

public class DatabaseView {

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

	private SchemaDao schemaDao = new SchemaDao();

	public BiConsumer<SchemaCreationData, Handle> createSchema = (dataContainer, handle) -> {
		schemaDao.createSchema(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SchemaCreationData, Handle> createTimelineTable = (dataContainer, handle) -> {
		aceDao.createTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SchemaCreationData, Handle> createErrorTimelineTable = (dataContainer, handle) -> {
		aceDao.createErrorTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SetupSchemaData, Handle> createUserTable = (dataContainer, handle) -> {
		userDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createCourseTable = (dataContainer, handle) -> {
		courseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createLessonTable = (dataContainer, handle) -> {
		lessonDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createTestTable = (dataContainer, handle) -> {
		testDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createResultTable = (dataContainer, handle) -> {
		resultDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createStudentOfCourseTable = (dataContainer, handle) -> {
		studentOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createBoxTable = (dataContainer, handle) -> {
		boxDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createCardTable = (dataContainer, handle) -> {
		cardDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createScheduledCardTable = (dataContainer, handle) -> {
		scheduledCardDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createScoredCardDaoTable = (dataContainer, handle) -> {
		scoredCardDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createBoxOfCourse = (dataContainer, handle) -> {
		boxOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createLoginLog = (dataContainer, handle) -> {
		loginLogDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> insertAdminUser = (dataContainer, handle) -> {
		IUserModel user = new UserModel(dataContainer.getUsername(), dataContainer.getPassword(),
				dataContainer.getName(), dataContainer.getPrename(), dataContainer.getEmail(), AuthUser.ADMIN, false);
		userDao.insert(handle, user, dataContainer.getSchema());
	};

}

/* S.D.G. */
