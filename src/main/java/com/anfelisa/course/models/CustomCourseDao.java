package com.anfelisa.course.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCourseDao {

	public List<ICourseModel> selectPublic(Handle handle) {
		return handle.createQuery("SELECT * FROM public.course WHERE isPublic = true ORDER By sequence")
				.map(new CourseMapper()).list();
	}

	public List<IMyCourseModel> selectMyCourses(Handle handle, String username) {
		return handle
				.createQuery("SELECT c.*, (SELECT count(*) as openTests from public.course "
						+ "inner join public.lesson on public.course.courseId = public.lesson.courseId "
						+ "inner join public.test on public.lesson.lessonId = public.test.lessonId "
						+ "left outer join public.result on public.test.testId = public.result.testId and public.result.username = :username "
						+ "WHERE public.result.resultId is null AND public.course.courseId = c.courseId) "
						+ "FROM public.course c, public.studentofcourse sc WHERE sc.username = :username AND c.courseId = sc.courseId ORDER BY sequence")
				.bind("username", username).map(new CustomMyCourseMapper()).list();
	}

	public List<ICourseModel> selectCourses(Handle handle, String username) {
		return handle
				.createQuery(
						"SELECT c.* FROM public.course c, public.studentofcourse sc WHERE sc.username = :username AND sc.courseId = c.courseId ORDER BY sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}

	public ICourseModel selectByLessonId(Handle handle, Integer lessonId) {
		return handle
				.createQuery(
						"SELECT c.* FROM public.course c, public.lesson l WHERE l.lessonId = :lessonId AND l.courseId = c.courseId")
				.bind("lessonId", lessonId).map(new CourseMapper()).first();
	}

	public ICourseModel selectByCourseIdAndUsername(Handle handle, Integer courseId, String username) {
		return handle
				.createQuery(
						"SELECT c.* FROM public.course c, public.studentofcourse sc WHERE c.courseId = :courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("courseId", courseId).bind("username", username).map(new CourseMapper()).first();
	}

	public List<ICourseModel> selectCourseSelection(Handle handle, String username) {
		return handle
				.createQuery(
						"select * from ( select * from public.course WHERE ispublic = true "
						+ "EXCEPT select c.* from public.course c inner join public.studentofcourse sc on sc.courseid = c.courseid where sc.username = :username) as courses order by sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}

	public List<ICourseModel> selectCourseSelectionPremium(Handle handle, String username) {
		return handle
				.createQuery(
						"select * from ( select * from public.course "
								+ "EXCEPT select c.* from public.course c inner join public.studentofcourse sc on sc.courseid = c.courseid where sc.username = :username) as courses order by sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}
	
}
