package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.course.data.CourseCreationData;
import com.anfelisa.course.models.CourseDao;

public class CourseView {

	public BiConsumer<CourseCreationData, Handle> createCourse = (dataContainer, handle) -> {
		// update view
		CourseDao.insertWithId(handle, dataContainer, dataContainer.getSchema());
	};

}

/*                    S.D.G.                    */
