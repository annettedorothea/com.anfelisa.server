package com.anfelisa.test.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class TestDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".test (id serial NOT NULL , name character varying NOT NULL , sequence integer , lessonId integer NOT NULL , html character varying NOT NULL , author character varying NOT NULL , CONSTRAINT test_pkey PRIMARY KEY (id), CONSTRAINT test_lessonId_fkey FOREIGN KEY (lessonId) REFERENCES " + schema + ".lesson ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ITestModel testModel, String schema) {
		if (testModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".test (id, name, sequence, lessonId, html, author) VALUES (:id, :name, :sequence, :lessonId, :html, :author)");
			statement.bind("id", testModel.getId());
			statement.bind("name", testModel.getName());
			statement.bind("sequence", testModel.getSequence());
			statement.bind("lessonId", testModel.getLessonId());
			statement.bind("html", testModel.getHtml());
			statement.bind("author", testModel.getAuthor());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".test (name, sequence, lessonId, html, author) VALUES (:name, :sequence, :lessonId, :html, :author)");
			statement.bind("name", testModel.getName());
			statement.bind("sequence", testModel.getSequence());
			statement.bind("lessonId", testModel.getLessonId());
			statement.bind("html", testModel.getHtml());
			statement.bind("author", testModel.getAuthor());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ITestModel testModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".test SET id = :id, name = :name, sequence = :sequence, lessonId = :lessonId, html = :html, author = :author");
		statement.bind("id", testModel.getId());
		statement.bind("name", testModel.getName());
		statement.bind("sequence", testModel.getSequence());
		statement.bind("lessonId", testModel.getLessonId());
		statement.bind("html", testModel.getHtml());
		statement.bind("author", testModel.getAuthor());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".test WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ITestModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".test WHERE id = :id")
			.bind("id", id)
			.map(new TestMapper())
			.first();
	}
	
	public static List<ITestModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".test")
			.map(new TestMapper())
			.list();
	}
}

/*       S.D.G.       */
