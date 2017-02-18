package com.anfelisa.lesson.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomLessonDao {

	public List<ILessonModel> selectLessons(Handle handle, Integer courseId) {
		return handle.createQuery("SELECT * FROM anfelisa.lesson WHERE courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).map(new LessonMapper()).list();
	}

	public List<IMyLessonModel> selectMyLessons(Handle handle, Integer courseId, String username) {
		return handle
				.createQuery("SELECT l.*, (SELECT count(*) as openTests from anfelisa.lesson "
						+ "inner join anfelisa.test on anfelisa.lesson.lessonId = anfelisa.test.lessonId "
						+ "left outer join anfelisa.result on anfelisa.test.testId = anfelisa.result.testId and anfelisa.result.username = :username "
						+ "WHERE anfelisa.result.resultId is null AND anfelisa.lesson.lessonId = l.lessonId) "
						+ "FROM anfelisa.lesson l WHERE l.courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).bind("username", username).map(new MyLessonMapper()).list();
	}

	public ILessonModel selectByTestId(Handle handle, Integer testId) {
		return handle
				.createQuery(
						"SELECT l.* FROM anfelisa.lesson l, anfelisa.test t WHERE t.testId = :testId AND t.lessonId = l.lessonId")
				.bind("testId", testId).map(new LessonMapper()).first();
	}

	public ILessonModel selectByLessonIdAndUsername(Handle handle, Integer lessonId, String username) {
		return handle
				.createQuery(
						"SELECT l.* FROM anfelisa.course c, anfelisa.studentofcourse sc, anfelisa.lesson l "
						+ "WHERE l.lessonId = :lessonId AND l.courseId = c.courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("lessonId", lessonId).bind("username", username).map(new LessonMapper()).first();

	}

}
