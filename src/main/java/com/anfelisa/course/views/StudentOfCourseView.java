package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.course.data.StudentToCourseAdditionData;
import com.anfelisa.course.models.StudentOfCourseDao;

public class StudentOfCourseView {

	private static StudentOfCourseDao studentOfCourseDao = new StudentOfCourseDao();

	public static BiConsumer<StudentToCourseAdditionData, Handle> addStudentToCourse = (dataContainer, handle) -> {
		studentOfCourseDao.insert(handle, dataContainer);
	};

}

/* S.D.G. */
