package com.anfelisa.lesson.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class LessonDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".lesson (id serial NOT NULL , name character varying NOT NULL , description character varying , sequence integer , courseId integer NOT NULL , author character varying NOT NULL , CONSTRAINT lesson_pkey PRIMARY KEY (id), CONSTRAINT lesson_courseId_fkey FOREIGN KEY (courseId) REFERENCES " + schema + ".course ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT lesson_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ILessonModel lessonModel, String schema) {
		if (lessonModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".lesson (id, name, description, sequence, courseId, author) VALUES (:id, :name, :description, :sequence, :courseId, :author)");
			statement.bind("id", lessonModel.getId());
			statement.bind("name", lessonModel.getName());
			statement.bind("description", lessonModel.getDescription());
			statement.bind("sequence", lessonModel.getSequence());
			statement.bind("courseId", lessonModel.getCourseId());
			statement.bind("author", lessonModel.getAuthor());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".lesson (name, description, sequence, courseId, author) VALUES (:name, :description, :sequence, :courseId, :author)");
			statement.bind("name", lessonModel.getName());
			statement.bind("description", lessonModel.getDescription());
			statement.bind("sequence", lessonModel.getSequence());
			statement.bind("courseId", lessonModel.getCourseId());
			statement.bind("author", lessonModel.getAuthor());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ILessonModel lessonModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".lesson SET id = :id, name = :name, description = :description, sequence = :sequence, courseId = :courseId, author = :author");
		statement.bind("id", lessonModel.getId());
		statement.bind("name", lessonModel.getName());
		statement.bind("description", lessonModel.getDescription());
		statement.bind("sequence", lessonModel.getSequence());
		statement.bind("courseId", lessonModel.getCourseId());
		statement.bind("author", lessonModel.getAuthor());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".lesson WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ILessonModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson WHERE id = :id")
			.bind("id", id)
			.map(new LessonMapper())
			.first();
	}
	
	public static List<ILessonModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".lesson")
			.map(new LessonMapper())
			.list();
	}
}

/*       S.D.G.       */
