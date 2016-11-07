package com.anfelisa.course.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCourseDao {

	public static List<ICourseModel> selectPublic(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE isPublic = true")
			.map(new CourseMapper())
			.list();
	}

}
