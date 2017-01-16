package com.anfelisa.lesson.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class LessonDao {
	
	public void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".lesson (lessonId serial NOT NULL  , name character varying NOT NULL  , description character varying  , sequence integer  , courseId integer NOT NULL  , author character varying NOT NULL  , CONSTRAINT lesson_pkey PRIMARY KEY (lessonId), CONSTRAINT lesson_courseId_fkey FOREIGN KEY (courseId) REFERENCES " + schema + ".course ( courseId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_lessonId_unique UNIQUE (lessonId))");
	}
	
	public Integer insert(Handle handle, ILessonModel lessonModel, String schema) {
		if (lessonModel.getLessonId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".lesson (lessonId, name, description, sequence, courseId, author) VALUES (:lessonId, :name, :description, :sequence, :courseId, :author)");
			statement.bind("lessonId", lessonModel.getLessonId());
			statement.bind("name", lessonModel.getName());
			statement.bind("description", lessonModel.getDescription());
			statement.bind("sequence", lessonModel.getSequence());
			statement.bind("courseId", lessonModel.getCourseId());
			statement.bind("author", lessonModel.getAuthor());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".lesson_lessonId_seq', (SELECT MAX(lessonId) FROM " + schema + ".lesson));").execute();
			return lessonModel.getLessonId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO " + schema + ".lesson (name, description, sequence, courseId, author) VALUES (:name, :description, :sequence, :courseId, :author) RETURNING lessonId");
			statement.bind("name", lessonModel.getName());
			statement.bind("description", lessonModel.getDescription());
			statement.bind("sequence", lessonModel.getSequence());
			statement.bind("courseId", lessonModel.getCourseId());
			statement.bind("author", lessonModel.getAuthor());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("lessonId");
		}
	}
	
	
	public void updateByLessonId(Handle handle, ILessonModel lessonModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".lesson SET lessonId = :lessonId, name = :name, description = :description, sequence = :sequence, courseId = :courseId, author = :author WHERE lessonId = :lessonId");
		statement.bind("lessonId", lessonModel.getLessonId());
		statement.bind("name", lessonModel.getName());
		statement.bind("description", lessonModel.getDescription());
		statement.bind("sequence", lessonModel.getSequence());
		statement.bind("courseId", lessonModel.getCourseId());
		statement.bind("author", lessonModel.getAuthor());
		statement.execute();
	}

	public void deleteByLessonId(Handle handle, Integer lessonId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".lesson WHERE lessonId = :lessonId");
		statement.bind("lessonId", lessonId);
		statement.execute();
	}

	public ILessonModel selectByLessonId(Handle handle, Integer lessonId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson WHERE lessonId = :lessonId")
			.bind("lessonId", lessonId)
			.map(new LessonMapper())
			.first();
	}
	
	public List<ILessonModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson")
			.map(new LessonMapper())
			.list();
	}
}

/*       S.D.G.       */
