package com.anfelisa.lesson.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomLessonDao {

	public static List<ILessonModel> selectLessons(Handle handle, String schema, Integer courseId) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson WHERE courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).map(new LessonMapper()).list();
	}

	public static List<IMyLessonModel> selectMyLessons(Handle handle, String schema, Integer courseId,
			String username) {
		return handle
				.createQuery("SELECT l.*, (SELECT count(*) as openTests from " + schema + ".lesson inner join " + schema
						+ ".test on " + schema + ".lesson.id = " + schema + ".test.lessonId left outer join " + schema
						+ ".result on " + schema + ".test.id = " + schema + ".result.testId and " + schema
						+ ".result.username = :username WHERE " + schema + ".result.id is null AND " + schema
						+ ".lesson.id = l.id) FROM " + schema
						+ ".lesson l WHERE l.courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).bind("username", username).map(new MyLessonMapper()).list();
	}

	public static ILessonModel selectByTestId(Handle handle, Integer testId, String schema) {
		return handle
				.createQuery("SELECT l.* FROM " + schema + ".lesson l, " + schema
						+ ".test t WHERE t.id = :testId AND t.lessonId = l.id")
				.bind("testId", testId).map(new LessonMapper()).first();
	}

	public static ILessonModel selectByLessonIdAndUsername(Handle handle, Integer lessonId, String username,
			String schema) {
		return handle
				.createQuery("SELECT l.* FROM " + schema + ".course c, " + schema + ".studentofcourse sc, " + schema
						+ ".lesson l WHERE l.id = :lessonId AND l.courseId = c.id AND sc.courseId = c.id AND sc.username = :username")
				.bind("lessonId", lessonId).bind("username", username).map(new LessonMapper()).first();

	}

}
