package com.anfelisa.course.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCourseDao {

	public List<ICourseModel> selectPublic(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.course WHERE isPublic = true ORDER By sequence")
				.map(new CourseMapper()).list();
	}

	public List<IMyCourseModel> selectMyCourses(Handle handle, String username) {
		return handle
				.createQuery("SELECT c.*, (SELECT count(*) as openTests from anfelisa.course "
						+ "inner join anfelisa.lesson on anfelisa.course.courseId = anfelisa.lesson.courseId "
						+ "inner join anfelisa.test on anfelisa.lesson.lessonId = anfelisa.test.lessonId "
						+ "left outer join anfelisa.result on anfelisa.test.testId = anfelisa.result.testId and anfelisa.result.username = :username "
						+ "WHERE anfelisa.result.resultId is null AND anfelisa.course.courseId = c.courseId) "
						+ "FROM anfelisa.course c, anfelisa.studentofcourse sc WHERE sc.username = :username AND c.courseId = sc.courseId ORDER BY sequence")
				.bind("username", username).map(new MyCourseMapper()).list();
	}

	public List<ICourseModel> selectCourses(Handle handle, String username) {
		return handle
				.createQuery(
						"SELECT c.* FROM anfelisa.course c, anfelisa.studentofcourse sc WHERE sc.username = :username AND sc.courseId = c.courseId ORDER BY sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}

	public ICourseModel selectByLessonId(Handle handle, Integer lessonId) {
		return handle
				.createQuery(
						"SELECT c.* FROM anfelisa.course c, anfelisa.lesson l WHERE l.lessonId = :lessonId AND l.courseId = c.courseId")
				.bind("lessonId", lessonId).map(new CourseMapper()).first();
	}

	public ICourseModel selectByCourseIdAndUsername(Handle handle, Integer courseId, String username) {
		return handle
				.createQuery(
						"SELECT c.* FROM anfelisa.course c, anfelisa.studentofcourse sc WHERE c.courseId = :courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("courseId", courseId).bind("username", username).map(new CourseMapper()).first();
	}

	public List<ICourseModel> selectCourseSelection(Handle handle, String username) {
		return handle
				.createQuery(
						"select * from ( select * from anfelisa.course WHERE ispublic = true "
						+ "EXCEPT select c.* from anfelisa.course c inner join anfelisa.studentofcourse sc on sc.courseid = c.courseid where sc.username = :username) as courses order by sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}

	public List<ICourseModel> selectCourseSelectionPremium(Handle handle, String username) {
		return handle
				.createQuery(
						"select * from ( select * from anfelisa.course "
								+ "EXCEPT select c.* from anfelisa.course c inner join anfelisa.studentofcourse sc on sc.courseid = c.courseid where sc.username = :username) as courses order by sequence")
				.bind("username", username).map(new CourseMapper()).list();
	}
	
}
