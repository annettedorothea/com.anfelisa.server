package com.anfelisa.course.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCourseDao {

	public static List<ICourseModel> selectPublic(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE isPublic = true ORDER By sequence")
			.map(new CourseMapper())
			.list();
	}

	public static ICourseModel selectByLessonId(Handle handle, Integer lessonId, String schema) {
		return handle.createQuery("SELECT c.* FROM " + schema + ".course c, " + schema + ".lesson l WHERE l.id = :lessonId AND l.courseId = c.id")
			.bind("lessonId", lessonId)
			.map(new CourseMapper())
			.first();
	}

}
