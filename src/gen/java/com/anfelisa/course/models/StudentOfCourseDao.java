package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class StudentOfCourseDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.studentofcourse (username character varying NOT NULL  , courseid integer NOT NULL  , CONSTRAINT studentofcourse_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT studentofcourse_courseid_fkey FOREIGN KEY (courseid) REFERENCES anfelisa.course ( courseid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE)");
	}
	
	public void insert(Handle handle, IStudentOfCourseModel studentOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO anfelisa.studentofcourse (username, courseid) VALUES (:username, :courseid)");
		statement.bind("username",  studentOfCourseModel.getUsername() );
		statement.bind("courseid",  studentOfCourseModel.getCourseId() );
		statement.execute();
	}
	
	
	
	public List<IStudentOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.studentofcourse")
			.map(new StudentOfCourseMapper())
			.list();
	}
}

/*       S.D.G.       */
