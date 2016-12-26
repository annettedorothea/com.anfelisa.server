package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxOfCourseListData;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxOfCourseDao;

public class BoxToCourseView {

	public BiConsumer<BoxToCourseAdditionData, Handle> addCourseToBox = (dataContainer, handle) -> {
		BoxOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<BoxOfCourseListData, Handle> addCoursesToBox = (dataContainer, handle) -> {
		//BoxOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
