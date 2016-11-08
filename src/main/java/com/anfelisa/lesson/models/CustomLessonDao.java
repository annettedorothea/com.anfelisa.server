package com.anfelisa.lesson.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomLessonDao {

	public static List<ILessonModel> selectPublicLessons(Handle handle, String schema, Integer courseId) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson WHERE courseId = :courseId ORDER By sequence")
			.bind("courseId", courseId)
			.map(new LessonMapper())
			.list();
	}

	public static ILessonModel selectByTestId(Handle handle, Integer testId, String schema) {
		return handle.createQuery("SELECT l.* FROM " + schema + ".lesson l, " + schema + ".test t WHERE t.id = :testId AND t.lessonId = l.id")
			.bind("testId", testId)
			.map(new LessonMapper())
			.first();
	}


}
