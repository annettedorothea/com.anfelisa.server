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
	
	public void insert(Handle handle, IStudentOfCourseModel studentOfCourseModel) {
		Update statement = handle.createStatement("INSERT INTO public.studentofcourse (username, courseid) VALUES (:username, :courseid)");
		statement.bind("username",  studentOfCourseModel.getUsername() );
		statement.bind("courseid",  studentOfCourseModel.getCourseId() );
		statement.execute();
	}
	
	
	
	public List<IStudentOfCourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT username, courseid FROM public.studentofcourse")
			.map(new StudentOfCourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.studentofcourse");
		statement.execute();
	}

}

/*       S.D.G.       */
