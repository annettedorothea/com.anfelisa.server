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
	
	public Integer insert(Handle handle, ICourseModel courseModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.course (name, description, sequence, ispublic, author) VALUES (:name, :description, :sequence, :ispublic, :author) RETURNING courseid");
		statement.bind("name",  courseModel.getName() );
		statement.bind("description",  courseModel.getDescription() );
		statement.bind("sequence",  courseModel.getSequence() );
		statement.bind("ispublic",  courseModel.getIsPublic() );
		statement.bind("author",  courseModel.getAuthor() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("courseid");
	}
	
	
	public void updateByCourseId(Handle handle, ICourseModel courseModel) {
		Update statement = handle.createStatement("UPDATE public.course SET name = :name, description = :description, sequence = :sequence, ispublic = :ispublic, author = :author WHERE courseid = :courseid");
		statement.bind("name",  courseModel.getName() );
		statement.bind("description",  courseModel.getDescription() );
		statement.bind("sequence",  courseModel.getSequence() );
		statement.bind("ispublic",  courseModel.getIsPublic() );
		statement.bind("author",  courseModel.getAuthor() );
		statement.bind("courseid",  courseModel.getCourseId()  );
		statement.execute();
	}

	public void deleteByCourseId(Handle handle, Integer courseId) {
		Update statement = handle.createStatement("DELETE FROM public.course WHERE courseid = :courseid");
		statement.bind("courseid", courseId);
		statement.execute();
	}

	public ICourseModel selectByCourseId(Handle handle, Integer courseId) {
		return handle.createQuery("SELECT courseid, name, description, sequence, ispublic, author FROM public.course WHERE courseid = :courseid")
			.bind("courseid", courseId)
			.map(new CourseMapper())
			.first();
	}
	
	public List<ICourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT courseid, name, description, sequence, ispublic, author FROM public.course")
			.map(new CourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.course CASCADE");
		statement.execute();
		statement = handle.createStatement("ALTER SEQUENCE public.course_courseId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
