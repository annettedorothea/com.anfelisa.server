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
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS public.course (courseid serial NOT NULL  , name character varying NOT NULL  , description character varying  , sequence integer  , ispublic boolean NOT NULL  , author character varying NOT NULL  , CONSTRAINT course_pkey PRIMARY KEY (courseid), CONSTRAINT course_author_fkey FOREIGN KEY (author) REFERENCES public.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT course_courseId_unique UNIQUE (courseId))");
	}
	
	public Integer insert(Handle handle, ICourseModel courseModel) {
		if (courseModel.getCourseId() != null) {
			Update statement = handle.createStatement("INSERT INTO public.course (courseid, name, description, sequence, ispublic, author) VALUES (:courseid, :name, :description, :sequence, :ispublic, :author)");
			statement.bind("courseid",  courseModel.getCourseId() );
			statement.bind("name",  courseModel.getName() );
			statement.bind("description",  courseModel.getDescription() );
			statement.bind("sequence",  courseModel.getSequence() );
			statement.bind("ispublic",  courseModel.getIsPublic() );
			statement.bind("author",  courseModel.getAuthor() );
			statement.execute();
			handle.createStatement("SELECT setval('public.course_courseid_seq', (SELECT MAX(courseid) FROM public.course));").execute();
			return courseModel.getCourseId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.course (name, description, sequence, ispublic, author) VALUES (:name, :description, :sequence, :ispublic, :author) RETURNING courseid");
			statement.bind("name",  courseModel.getName() );
			statement.bind("description",  courseModel.getDescription() );
			statement.bind("sequence",  courseModel.getSequence() );
			statement.bind("ispublic",  courseModel.getIsPublic() );
			statement.bind("author",  courseModel.getAuthor() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("courseid");
		}
	}
	
	
	public void updateByCourseId(Handle handle, ICourseModel courseModel) {
		Update statement = handle.createStatement("UPDATE public.course SET courseid = :courseid, name = :name, description = :description, sequence = :sequence, ispublic = :ispublic, author = :author WHERE courseid = :courseid");
		statement.bind("courseid",  courseModel.getCourseId() );
		statement.bind("name",  courseModel.getName() );
		statement.bind("description",  courseModel.getDescription() );
		statement.bind("sequence",  courseModel.getSequence() );
		statement.bind("ispublic",  courseModel.getIsPublic() );
		statement.bind("author",  courseModel.getAuthor() );
		statement.execute();
	}

	public void deleteByCourseId(Handle handle, Integer courseId) {
		Update statement = handle.createStatement("DELETE FROM public.course WHERE courseid = :courseid");
		statement.bind("courseid", courseId);
		statement.execute();
	}

	public ICourseModel selectByCourseId(Handle handle, Integer courseId) {
		return handle.createQuery("SELECT * FROM public.course WHERE courseid = :courseid")
			.bind("courseid", courseId)
			.map(new CourseMapper())
			.first();
	}
	
	public List<ICourseModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.course")
			.map(new CourseMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.course");
		statement.execute();
	}

}

/*       S.D.G.       */
