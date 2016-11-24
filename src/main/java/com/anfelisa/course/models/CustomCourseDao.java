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
						+ ".lesson on " + schema + ".course.id = " + schema + ".lesson.courseId inner join " + schema
						+ ".test on " + schema + ".lesson.id = " + schema + ".test.lessonId left outer join " + schema
						+ ".result on " + schema + ".test.id = " + schema + ".result.testId and " + schema
						+ ".result.username = :username WHERE " + schema + ".result.id is null AND " + schema
						+ ".course.id = c.id) FROM " + schema + ".course c, " + schema
						+ ".studentofcourse sc WHERE sc.username = :username AND c.id = sc.courseId ORDER By sequence")
				.bind("username", username).map(new MyCourseMapper()).list();
	}

	public static ICourseModel selectByLessonId(Handle handle, Integer lessonId, String schema) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".course c, " + schema
						+ ".lesson l WHERE l.id = :lessonId AND l.courseId = c.id")
				.bind("lessonId", lessonId).map(new CourseMapper()).first();
	}

}
