package com.anfelisa.lesson.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomLessonDao {

	public List<ILessonModel> selectLessons(Handle handle, Integer courseId) {
		return handle.createQuery("SELECT * FROM public.lesson WHERE courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).map(new LessonMapper()).list();
	}

	public List<IMyLessonModel> selectMyLessons(Handle handle, Integer courseId, String username) {
		return handle
				.createQuery("SELECT l.*, (SELECT count(*) as openTests from public.lesson "
						+ "inner join public.test on public.lesson.lessonId = public.test.lessonId "
						+ "left outer join public.result on public.test.testId = public.result.testId and public.result.username = :username "
						+ "WHERE public.result.resultId is null AND public.lesson.lessonId = l.lessonId) "
						+ "FROM public.lesson l WHERE l.courseId = :courseId ORDER By sequence")
				.bind("courseId", courseId).bind("username", username).map(new CustomMyLessonMapper()).list();
	}

	public ILessonModel selectByTestId(Handle handle, Integer testId) {
		return handle
				.createQuery(
						"SELECT l.* FROM public.lesson l, public.test t WHERE t.testId = :testId AND t.lessonId = l.lessonId")
				.bind("testId", testId).map(new LessonMapper()).first();
	}

	public ILessonModel selectByLessonIdAndUsername(Handle handle, Integer lessonId, String username) {
		return handle
				.createQuery(
						"SELECT l.* FROM public.course c, public.studentofcourse sc, public.lesson l "
						+ "WHERE l.lessonId = :lessonId AND l.courseId = c.courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("lessonId", lessonId).bind("username", username).map(new LessonMapper()).first();

	}

}
