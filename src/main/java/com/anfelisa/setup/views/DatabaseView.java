package com.anfelisa.setup.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.AceDao;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CardOfBoxDao;
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

	public BiConsumer<SchemaCreationData, Handle> createSchema = (dataContainer, handle) -> {
		SchemaDao.createSchema(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SchemaCreationData, Handle> createTimelineTable = (dataContainer, handle) -> {
		AceDao.createTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SchemaCreationData, Handle> createErrorTimelineTable = (dataContainer, handle) -> {
		AceDao.createErrorTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SetupSchemaData, Handle> createUserTable = (dataContainer, handle) -> {
		UserDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createCourseTable = (dataContainer, handle) -> {
		CourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createLessonTable = (dataContainer, handle) -> {
		LessonDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createTestTable = (dataContainer, handle) -> {
		TestDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createResultTable = (dataContainer, handle) -> {
		ResultDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createStudentOfCourseTable = (dataContainer, handle) -> {
		StudentOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createBoxTable = (dataContainer, handle) -> {
		BoxDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createCardTable = (dataContainer, handle) -> {
		CardDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createCardOfBoxTable = (dataContainer, handle) -> {
		CardOfBoxDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createBoxOfCourse = (dataContainer, handle) -> {
		BoxOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> createLoginLog = (dataContainer, handle) -> {
		LoginLogDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupSchemaData, Handle> insertAdminUser = (dataContainer, handle) -> {
		IUserModel user = new UserModel(dataContainer.getUsername(), dataContainer.getPassword(),
				dataContainer.getName(), dataContainer.getPrename(), dataContainer.getEmail(), AuthUser.ADMIN, false);
		UserDao.insert(handle, user, dataContainer.getSchema());
	};

}

/* S.D.G. */
