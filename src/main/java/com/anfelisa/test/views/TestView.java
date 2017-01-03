package com.anfelisa.test.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.test.data.TestCreationData;
import com.anfelisa.test.models.TestDao;

public class TestView {

	public BiConsumer<TestCreationData, Handle> createTest = (dataContainer, handle) -> {
		Integer testId = TestDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setTestId(testId);
	};

	public BiConsumer<TestCreationData, Handle> updateTest = (dataContainer, handle) -> {
		TestDao.updateByTestId(handle, dataContainer, dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
