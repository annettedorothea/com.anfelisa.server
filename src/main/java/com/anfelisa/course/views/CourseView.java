package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseCreationData;
import com.anfelisa.course.data.CourseData;
import com.anfelisa.course.data.CourseIdData;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.lesson.views.LessonView;

public class CourseView {

	static final Logger LOG = LoggerFactory.getLogger(LessonView.class);

	private static CourseDao courseDao = new CourseDao();

	public static BiConsumer<CourseCreationData, Handle> createCourse = (dataContainer, handle) -> {
		courseDao.insert(handle, dataContainer);
	};

	public static BiConsumer<CourseData, Handle> updateCourse = (dataContainer, handle) -> {
		courseDao.updateByCourseId(handle, dataContainer);
	};

	public static BiConsumer<CourseIdData, Handle> deleteCourse = (dataContainer, handle) -> {
		courseDao.deleteByCourseId(handle, dataContainer.getCourseId());
	};
	
}

/* S.D.G. */
