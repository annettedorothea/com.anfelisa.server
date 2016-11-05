package com.anfelisa.course.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.course.data.StudentToCourseAdditionData;
import com.anfelisa.course.models.StudentOfCourseDao;

public class StudentOfCourseView {

	public BiConsumer<StudentToCourseAdditionData, Handle> addStudentToCourse = (dataContainer, handle) -> {
		StudentOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

}

/*                    S.D.G.                    */
