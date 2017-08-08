package com.anfelisa.lesson.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class LessonDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS public.lesson (lessonid serial NOT NULL  , name character varying NOT NULL  , description character varying  , sequence integer  , courseid integer NOT NULL  , author character varying NOT NULL  , CONSTRAINT lesson_pkey PRIMARY KEY (lessonid), CONSTRAINT lesson_courseid_fkey FOREIGN KEY (courseid) REFERENCES public.course ( courseid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_author_fkey FOREIGN KEY (author) REFERENCES public.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_lessonId_unique UNIQUE (lessonId))");
	}
	
	public Integer insert(Handle handle, ILessonModel lessonModel) {
		if (lessonModel.getLessonId() != null) {
			Update statement = handle.createStatement("INSERT INTO public.lesson (lessonid, name, description, sequence, courseid, author) VALUES (:lessonid, :name, :description, :sequence, :courseid, :author)");
			statement.bind("lessonid",  lessonModel.getLessonId() );
			statement.bind("name",  lessonModel.getName() );
			statement.bind("description",  lessonModel.getDescription() );
			statement.bind("sequence",  lessonModel.getSequence() );
			statement.bind("courseid",  lessonModel.getCourseId() );
			statement.bind("author",  lessonModel.getAuthor() );
			statement.execute();
			handle.createStatement("SELECT setval('public.lesson_lessonid_seq', (SELECT MAX(lessonid) FROM public.lesson));").execute();
			return lessonModel.getLessonId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.lesson (name, description, sequence, courseid, author) VALUES (:name, :description, :sequence, :courseid, :author) RETURNING lessonid");
			statement.bind("name",  lessonModel.getName() );
			statement.bind("description",  lessonModel.getDescription() );
			statement.bind("sequence",  lessonModel.getSequence() );
			statement.bind("courseid",  lessonModel.getCourseId() );
			statement.bind("author",  lessonModel.getAuthor() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("lessonid");
		}
	}
	
	
	public void updateByLessonId(Handle handle, ILessonModel lessonModel) {
		Update statement = handle.createStatement("UPDATE public.lesson SET lessonid = :lessonid, name = :name, description = :description, sequence = :sequence, courseid = :courseid, author = :author WHERE lessonid = :lessonid");
		statement.bind("lessonid",  lessonModel.getLessonId() );
		statement.bind("name",  lessonModel.getName() );
		statement.bind("description",  lessonModel.getDescription() );
		statement.bind("sequence",  lessonModel.getSequence() );
		statement.bind("courseid",  lessonModel.getCourseId() );
		statement.bind("author",  lessonModel.getAuthor() );
		statement.execute();
	}

	public void deleteByLessonId(Handle handle, Integer lessonId) {
		Update statement = handle.createStatement("DELETE FROM public.lesson WHERE lessonid = :lessonid");
		statement.bind("lessonid", lessonId);
		statement.execute();
	}

	public ILessonModel selectByLessonId(Handle handle, Integer lessonId) {
		return handle.createQuery("SELECT * FROM public.lesson WHERE lessonid = :lessonid")
			.bind("lessonid", lessonId)
			.map(new LessonMapper())
			.first();
	}
	
	public List<ILessonModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.lesson")
			.map(new LessonMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.lesson");
		statement.execute();
	}

}

/*       S.D.G.       */
