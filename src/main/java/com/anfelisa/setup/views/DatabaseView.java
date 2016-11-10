package com.anfelisa.setup.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.AceDao;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.StudentOfCourseDao;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.models.SchemaDao;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.setup.data.SetupData;
import com.anfelisa.setup.data.SetupSchemaData;
import com.anfelisa.test.models.TestDao;
import com.anfelisa.user.models.LoginLogDao;
import com.anfelisa.user.models.UserDao;

public class DatabaseView {

	public BiConsumer<SetupSchemaData, Handle> createSchema = (dataContainer, handle) -> {
		SchemaDao.createSchema(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SetupSchemaData, Handle> createTimelineTable = (dataContainer, handle) -> {
		AceDao.createTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SetupSchemaData, Handle> createErrorTimelineTable = (dataContainer, handle) -> {
		AceDao.createErrorTimelineTable(handle, dataContainer.getSchemaToBeCreated());
	};
	public BiConsumer<SetupData, Handle> createUserTable = (dataContainer, handle) -> {
		UserDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createCourseTable = (dataContainer, handle) -> {
		CourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createLessonTable = (dataContainer, handle) -> {
		LessonDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createTestTable = (dataContainer, handle) -> {
		TestDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createResultTable = (dataContainer, handle) -> {
		ResultDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createStudentOfCourseTable = (dataContainer, handle) -> {
		StudentOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createBoxTable = (dataContainer, handle) -> {
		BoxDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createCardTable = (dataContainer, handle) -> {
		CardDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createCardOfBoxTable = (dataContainer, handle) -> {
		CardOfBoxDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createBoxOfCourse = (dataContainer, handle) -> {
		BoxOfCourseDao.create(handle, dataContainer.getSchema());
	};
	public BiConsumer<SetupData, Handle> createLoginLog = (dataContainer, handle) -> {
		LoginLogDao.create(handle, dataContainer.getSchema());
	};

}

/*                    S.D.G.                    */
