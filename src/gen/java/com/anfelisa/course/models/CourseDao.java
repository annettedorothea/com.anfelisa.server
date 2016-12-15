package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CourseDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".course (courseId serial NOT NULL  , name character varying NOT NULL  , description character varying  , sequence integer  , isPublic boolean NOT NULL  , author character varying NOT NULL  , CONSTRAINT course_pkey PRIMARY KEY (courseId), CONSTRAINT course_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT course_courseId_unique UNIQUE (courseId))");
	}
	
	public static void insert(Handle handle, ICourseModel courseModel, String schema) {
		if (courseModel.getCourseId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".course (courseId, name, description, sequence, isPublic, author) VALUES (:courseId, :name, :description, :sequence, :isPublic, :author)");
			statement.bind("courseId", courseModel.getCourseId());
			statement.bind("name", courseModel.getName());
			statement.bind("description", courseModel.getDescription());
			statement.bind("sequence", courseModel.getSequence());
			statement.bind("isPublic", courseModel.getIsPublic());
			statement.bind("author", courseModel.getAuthor());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".course_courseId_seq', (SELECT MAX(courseId) FROM " + schema + ".course));").execute();
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
		Update statement = handle.createStatement("UPDATE " + schema + ".course SET courseId = :courseId, name = :name, description = :description, sequence = :sequence, isPublic = :isPublic, author = :author");
		statement.bind("courseId", courseModel.getCourseId());
		statement.bind("name", courseModel.getName());
		statement.bind("description", courseModel.getDescription());
		statement.bind("sequence", courseModel.getSequence());
		statement.bind("isPublic", courseModel.getIsPublic());
		statement.bind("author", courseModel.getAuthor());
		statement.execute();
	}
	
	public static void deleteByCourseId(Handle handle, Integer courseId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".course WHERE courseId = :courseId");
		statement.bind("courseId", courseId);
		statement.execute();
	}

	public static ICourseModel selectByCourseId(Handle handle, Integer courseId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE courseId = :courseId")
			.bind("courseId", courseId)
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
