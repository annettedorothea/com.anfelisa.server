package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.course.data.CourseCreationData;
import com.anfelisa.course.data.CourseData;
import com.anfelisa.course.models.CourseDao;

public class CourseView {

	public BiConsumer<CourseCreationData, Handle> createCourse = (dataContainer, handle) -> {
		Integer courseId = CourseDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCourseId(courseId);
	};

	public BiConsumer<CourseData, Handle> updateCourse = (dataContainer, handle) -> {
		CourseDao.updateByCourseId(handle, dataContainer, dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
