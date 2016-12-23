package com.anfelisa.course.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCourseDao {

	public static List<ICourseModel> selectPublic(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE isPublic = true ORDER By sequence")
				.map(new CourseMapper()).list();
	}

	public static List<IMyCourseModel> selectMyCourses(Handle handle, String schema, String username) {
		return handle
				.createQuery("SELECT c.*, (SELECT count(*) as openTests from " + schema + ".course inner join " + schema
						+ ".lesson on " + schema + ".course.courseId = " + schema + ".lesson.courseId inner join " + schema
						+ ".test on " + schema + ".lesson.lessonId = " + schema + ".test.lessonId left outer join " + schema
						+ ".result on " + schema + ".test.testId = " + schema + ".result.testId and " + schema
						+ ".result.username = :username WHERE " + schema + ".result.resultId is null AND " + schema
						+ ".course.courseId = c.courseId) FROM " + schema + ".course c, " + schema
						+ ".studentofcourse sc WHERE sc.username = :username AND c.courseId = sc.courseId ORDER By sequence")
				.bind("username", username).map(new MyCourseMapper()).list();
	}

	public static List<ICourseModel> selectCourses(Handle handle, String schema, String username) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".course c, " + schema
						+ ".studentofcourse sc WHERE sc.username = :username AND sc.courseId = c.courseId")
				.bind("username", username).map(new CourseMapper()).list();
	}
	
	public static ICourseModel selectByLessonId(Handle handle, Integer lessonId, String schema) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".course c, " + schema
						+ ".lesson l WHERE l.lessonId = :lessonId AND l.courseId = c.courseId")
				.bind("lessonId", lessonId).map(new CourseMapper()).first();
	}

	public static ICourseModel selectByCourseIdAndUsername(Handle handle, Integer courseId, String username, String schema) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".course c, " + schema
						+ ".studentofcourse sc WHERE c.courseId = :courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("courseId", courseId)
				.bind("username", username)
				.map(new CourseMapper()).first();
	}
	
}
