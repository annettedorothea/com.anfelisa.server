package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class StudentOfCourseDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.studentofcourse (username character varying NOT NULL  , courseId integer NOT NULL  , CONSTRAINT studentofcourse_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT studentofcourse_courseId_fkey FOREIGN KEY (courseId) REFERENCES anfelisa.course ( courseId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public void insert(Handle handle, IStudentOfCourseModel studentOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO anfelisa.studentofcourse (username, courseId) VALUES (:username, :courseId)");
		statement.bind("username", studentOfCourseModel.getUsername());
		statement.bind("courseId", studentOfCourseModel.getCourseId());
		statement.execute();
	}
	
	
	
	public List<IStudentOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.studentofcourse")
			.map(new StudentOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
