package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CourseDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".course (id serial NOT NULL , name character varying NOT NULL , description character varying , sequence integer , isPublic boolean NOT NULL , author character varying NOT NULL , CONSTRAINT course_pkey PRIMARY KEY (id), CONSTRAINT course_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT course_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ICourseModel courseModel, String schema) {
		if (courseModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".course (id, name, description, sequence, isPublic, author) VALUES (:id, :name, :description, :sequence, :isPublic, :author)");
			statement.bind("id", courseModel.getId());
			statement.bind("name", courseModel.getName());
			statement.bind("description", courseModel.getDescription());
			statement.bind("sequence", courseModel.getSequence());
			statement.bind("isPublic", courseModel.getIsPublic());
			statement.bind("author", courseModel.getAuthor());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".course (name, description, sequence, isPublic, author) VALUES (:name, :description, :sequence, :isPublic, :author)");
			statement.bind("name", courseModel.getName());
			statement.bind("description", courseModel.getDescription());
			statement.bind("sequence", courseModel.getSequence());
			statement.bind("isPublic", courseModel.getIsPublic());
			statement.bind("author", courseModel.getAuthor());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ICourseModel courseModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".course SET id = :id, name = :name, description = :description, sequence = :sequence, isPublic = :isPublic, author = :author");
		statement.bind("id", courseModel.getId());
		statement.bind("name", courseModel.getName());
		statement.bind("description", courseModel.getDescription());
		statement.bind("sequence", courseModel.getSequence());
		statement.bind("isPublic", courseModel.getIsPublic());
		statement.bind("author", courseModel.getAuthor());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".course WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ICourseModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE id = :id")
			.bind("id", id)
			.map(new CourseMapper())
			.first();
	}
	
	public static List<ICourseModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course")
			.map(new CourseMapper())
			.list();
	}
}

/*       S.D.G.       */
