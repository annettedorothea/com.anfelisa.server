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
public class CourseDao {
	
	public void insert(Handle handle, ICourseModel courseModel) {
		Update statement = handle.createStatement("INSERT INTO public.course (courseid, name, description, sequence, author) VALUES (:courseid, :name, :description, :sequence, :author)");
		statement.bind("courseid",  courseModel.getCourseId() );
		statement.bind("name",  courseModel.getName() );
		statement.bind("description",  courseModel.getDescription() );
		statement.bind("sequence",  courseModel.getSequence() );
		statement.bind("author",  courseModel.getAuthor() );
		statement.execute();
	}
	
	
	public void updateByCourseId(Handle handle, ICourseModel courseModel) {
		Update statement = handle.createStatement("UPDATE public.course SET courseid = :courseid, name = :name, description = :description, sequence = :sequence, author = :author WHERE courseid = :courseid");
		statement.bind("courseid",  courseModel.getCourseId() );
		statement.bind("name",  courseModel.getName() );
		statement.bind("description",  courseModel.getDescription() );
		statement.bind("sequence",  courseModel.getSequence() );
		statement.bind("author",  courseModel.getAuthor() );
		statement.bind("courseid",  courseModel.getCourseId()  );
		statement.execute();
	}

	public void deleteByCourseId(Handle handle, String courseId) {
		Update statement = handle.createStatement("DELETE FROM public.course WHERE courseid = :courseid");
		statement.bind("courseid", courseId);
		statement.execute();
	}

	public ICourseModel selectByCourseId(Handle handle, String courseId) {
		return handle.createQuery("SELECT courseid, name, description, sequence, author FROM public.course WHERE courseid = :courseid")
			.bind("courseid", courseId)
			.map(new CourseMapper())
			.first();
	}
	
	public List<ICourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT courseid, name, description, sequence, author FROM public.course")
			.map(new CourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.course CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
