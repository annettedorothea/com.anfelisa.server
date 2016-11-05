package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class StudentOfCourseDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".studentofcourse (username character varying NOT NULL , courseId integer NOT NULL , CONSTRAINT studentofcourse_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT studentofcourse_courseId_fkey FOREIGN KEY (courseId) REFERENCES " + schema + ".course ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public static void insert(Handle handle, IStudentOfCourseModel studentOfCourseModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".studentofcourse (username, courseId) VALUES (:username, :courseId)");
		statement.bind("username", studentOfCourseModel.getUsername());
		statement.bind("courseId", studentOfCourseModel.getCourseId());
		statement.execute();
	}
	
	public static void update(Handle handle, IStudentOfCourseModel studentOfCourseModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".studentofcourse SET username = :username, courseId = :courseId");
		statement.bind("username", studentOfCourseModel.getUsername());
		statement.bind("courseId", studentOfCourseModel.getCourseId());
		statement.execute();
	}
	
	
	public static List<IStudentOfCourseModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".studentofcourse")
			.map(new StudentOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
