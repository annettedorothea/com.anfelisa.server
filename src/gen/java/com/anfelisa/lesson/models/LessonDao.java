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
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.lesson (lessonid serial NOT NULL  , name character varying NOT NULL  , description character varying  , sequence integer  , courseid integer NOT NULL  , author character varying NOT NULL  , CONSTRAINT lesson_pkey PRIMARY KEY (lessonid), CONSTRAINT lesson_courseid_fkey FOREIGN KEY (courseid) REFERENCES anfelisa.course ( courseid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_author_fkey FOREIGN KEY (author) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_lessonId_unique UNIQUE (lessonId))");
	}
	
	public Integer insert(Handle handle, ILessonModel lessonModel) {
		if (lessonModel.getLessonId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.lesson (lessonid, name, description, sequence, courseid, author) VALUES (:lessonid, :name, :description, :sequence, :courseid, :author)");
			statement.bind("lessonid",  lessonModel.getLessonId() );
			statement.bind("name",  lessonModel.getName() );
			statement.bind("description",  lessonModel.getDescription() );
			statement.bind("sequence",  lessonModel.getSequence() );
			statement.bind("courseid",  lessonModel.getCourseId() );
			statement.bind("author",  lessonModel.getAuthor() );
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.lesson_lessonid_seq', (SELECT MAX(lessonid) FROM anfelisa.lesson));").execute();
			return lessonModel.getLessonId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.lesson (name, description, sequence, courseid, author) VALUES (:name, :description, :sequence, :courseid, :author) RETURNING lessonid");
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
		Update statement = handle.createStatement("UPDATE anfelisa.lesson SET lessonid = :lessonid, name = :name, description = :description, sequence = :sequence, courseid = :courseid, author = :author WHERE lessonid = :lessonid");
		statement.bind("lessonid",  lessonModel.getLessonId() );
		statement.bind("name",  lessonModel.getLessonId() );
		statement.bind("description",  lessonModel.getLessonId() );
		statement.bind("sequence",  lessonModel.getLessonId() );
		statement.bind("courseid",  lessonModel.getLessonId() );
		statement.bind("author",  lessonModel.getLessonId() );
		statement.execute();
	}

	public void deleteByLessonId(Handle handle, Integer lessonId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.lesson WHERE lessonid = :lessonid");
		statement.bind("lessonid", lessonId);
		statement.execute();
	}

	public ILessonModel selectByLessonId(Handle handle, Integer lessonId) {
		return handle.createQuery("SELECT * FROM anfelisa.lesson WHERE lessonid = :lessonid")
			.bind("lessonid", lessonId)
			.map(new LessonMapper())
			.first();
	}
	
	public List<ILessonModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.lesson")
			.map(new LessonMapper())
			.list();
	}
}

/*       S.D.G.       */
