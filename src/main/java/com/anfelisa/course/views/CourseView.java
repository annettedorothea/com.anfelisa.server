package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.course.data.CourseCreationData;
import com.anfelisa.course.data.CourseData;
import com.anfelisa.course.data.CourseIdData;
import com.anfelisa.course.models.CourseDao;

public class CourseView {

	private static CourseDao courseDao = new CourseDao();

	public static BiConsumer<CourseCreationData, Handle> createCourse = (dataContainer, handle) -> {
		Integer courseId = courseDao.insert(handle, dataContainer);
		dataContainer.setCreatedId("" + courseId);
	};

	public static BiConsumer<CourseData, Handle> updateCourse = (dataContainer, handle) -> {
		courseDao.updateByCourseId(handle, dataContainer);
	};

	public static BiConsumer<CourseIdData, Handle> deleteCourse = (dataContainer, handle) -> {
		courseDao.deleteByCourseId(handle, dataContainer.getCourseId());
	};
	
}

/* S.D.G. */
