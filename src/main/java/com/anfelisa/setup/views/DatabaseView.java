package com.anfelisa.setup.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.AceDao;
import com.anfelisa.models.SchemaDao;
import com.anfelisa.setup.data.SetupData;
import com.anfelisa.setup.data.SetupSchemaData;
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
		// update view
	};
	public BiConsumer<SetupData, Handle> createLessonTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createTestTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createResultTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createStudentOfCourseTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createBoxTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createCardTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createCardOfBoxTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createStudentOfBoxTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createAddCardsAfterEditToBoxTable = (dataContainer, handle) -> {
		// update view
	};
	public BiConsumer<SetupData, Handle> createAddAllCardsToBoxTable = (dataContainer, handle) -> {
		// update view
	};

}

/*                    S.D.G.                    */
