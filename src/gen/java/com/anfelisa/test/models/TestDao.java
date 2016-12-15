package com.anfelisa.test.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class TestDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".test (testId serial NOT NULL  , name character varying NOT NULL  , sequence integer  , lessonId integer NOT NULL  , html character varying NOT NULL  , author character varying NOT NULL  , CONSTRAINT test_pkey PRIMARY KEY (testId), CONSTRAINT test_lessonId_fkey FOREIGN KEY (lessonId) REFERENCES " + schema + ".lesson ( lessonId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_author_fkey FOREIGN KEY (author) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_testId_unique UNIQUE (testId))");
	}
	
	public static void insert(Handle handle, ITestModel testModel, String schema) {
		if (testModel.getTestId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".test (testId, name, sequence, lessonId, html, author) VALUES (:testId, :name, :sequence, :lessonId, :html, :author)");
			statement.bind("testId", testModel.getTestId());
			statement.bind("name", testModel.getName());
			statement.bind("sequence", testModel.getSequence());
			statement.bind("lessonId", testModel.getLessonId());
			statement.bind("html", testModel.getHtml());
			statement.bind("author", testModel.getAuthor());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".test_testId_seq', (SELECT MAX(testId) FROM " + schema + ".test));").execute();
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
		Update statement = handle.createStatement("UPDATE " + schema + ".test SET testId = :testId, name = :name, sequence = :sequence, lessonId = :lessonId, html = :html, author = :author");
		statement.bind("testId", testModel.getTestId());
		statement.bind("name", testModel.getName());
		statement.bind("sequence", testModel.getSequence());
		statement.bind("lessonId", testModel.getLessonId());
		statement.bind("html", testModel.getHtml());
		statement.bind("author", testModel.getAuthor());
		statement.execute();
	}
	
	public static void deleteByTestId(Handle handle, Integer testId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".test WHERE testId = :testId");
		statement.bind("testId", testId);
		statement.execute();
	}

	public static ITestModel selectByTestId(Handle handle, Integer testId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".test WHERE testId = :testId")
			.bind("testId", testId)
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
