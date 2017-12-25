package com.anfelisa.test.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.test.data.TestCreationData;
import com.anfelisa.test.models.TestDao;

public class TestView {

	private static TestDao testDao = new TestDao();

	public static BiConsumer<TestCreationData, Handle> createTest = (dataContainer, handle) -> {
		Integer testId = testDao.insert(handle, dataContainer);
		dataContainer.setCreatedId("" + testId);
	};

	public static BiConsumer<TestCreationData, Handle> updateTest = (dataContainer, handle) -> {
		testDao.updateByTestId(handle, dataContainer);
	};

}

/* S.D.G. */
