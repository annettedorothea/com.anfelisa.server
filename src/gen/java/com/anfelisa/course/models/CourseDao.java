package com.anfelisa.course.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CourseDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".course (id serial , name character varying , description character varying , sequence integer , isPublic boolean , CONSTRAINT course_pkey PRIMARY KEY (id), CONSTRAINT course_id_unique UNIQUE (id))");
	}
	
	public static void insertWithId(Handle handle, ICourseModel courseModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".course (id, name, description, sequence, isPublic) VALUES (:id, :name, :description, :sequence, :isPublic)");
		statement.bind("id", courseModel.getId());
		statement.bind("name", courseModel.getName());
		statement.bind("description", courseModel.getDescription());
		statement.bind("sequence", courseModel.getSequence());
		statement.bind("isPublic", courseModel.getIsPublic());
		statement.execute();
	}
	
	public static void insert(Handle handle, ICourseModel courseModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".course (name, description, sequence, isPublic) VALUES (:name, :description, :sequence, :isPublic)");
		statement.bind("name", courseModel.getName());
		statement.bind("description", courseModel.getDescription());
		statement.bind("sequence", courseModel.getSequence());
		statement.bind("isPublic", courseModel.getIsPublic());
		statement.execute();
	}
	
	public static void update(Handle handle, ICourseModel courseModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".course SET id = :id, name = :name, description = :description, sequence = :sequence, isPublic = :isPublic");
		statement.bind("id", courseModel.getId());
		statement.bind("name", courseModel.getName());
		statement.bind("description", courseModel.getDescription());
		statement.bind("sequence", courseModel.getSequence());
		statement.bind("isPublic", courseModel.getIsPublic());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, ICourseModel courseModel, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".course WHERE id = :id");
		statement.bind("id", courseModel.getId());
		statement.execute();
	}

	public static ICourseModel selectById(Handle handle, ICourseModel courseModel, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".course WHERE id = :id")
			.bind("id", courseModel.getId())
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
