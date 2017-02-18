package com.anfelisa.test.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class TestDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.test (testId serial NOT NULL  , name character varying NOT NULL  , sequence integer  , lessonId integer NOT NULL  , html character varying NOT NULL  , author character varying NOT NULL  , CONSTRAINT test_pkey PRIMARY KEY (testId), CONSTRAINT test_lessonId_fkey FOREIGN KEY (lessonId) REFERENCES anfelisa.lesson ( lessonId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_author_fkey FOREIGN KEY (author) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_testId_unique UNIQUE (testId))");
	}
	
	public Integer insert(Handle handle, ITestModel testModel) {
		if (testModel.getTestId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.test (testId, name, sequence, lessonId, html, author) VALUES (:testId, :name, :sequence, :lessonId, :html, :author)");
			statement.bind("testId", testModel.getTestId());
			statement.bind("name", testModel.getName());
			statement.bind("sequence", testModel.getSequence());
			statement.bind("lessonId", testModel.getLessonId());
			statement.bind("html", testModel.getHtml());
			statement.bind("author", testModel.getAuthor());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.test_testId_seq', (SELECT MAX(testId) FROM anfelisa.test));").execute();
			return testModel.getTestId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.test (name, sequence, lessonId, html, author) VALUES (:name, :sequence, :lessonId, :html, :author) RETURNING testId");
			statement.bind("name", testModel.getName());
			statement.bind("sequence", testModel.getSequence());
			statement.bind("lessonId", testModel.getLessonId());
			statement.bind("html", testModel.getHtml());
			statement.bind("author", testModel.getAuthor());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("testId");
		}
	}
	
	
	public void updateByTestId(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.test SET testId = :testId, name = :name, sequence = :sequence, lessonId = :lessonId, html = :html, author = :author WHERE testId = :testId");
		statement.bind("testId", testModel.getTestId());
		statement.bind("name", testModel.getName());
		statement.bind("sequence", testModel.getSequence());
		statement.bind("lessonId", testModel.getLessonId());
		statement.bind("html", testModel.getHtml());
		statement.bind("author", testModel.getAuthor());
		statement.execute();
	}

	public void deleteByTestId(Handle handle, Integer testId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.test WHERE testId = :testId");
		statement.bind("testId", testId);
		statement.execute();
	}

	public ITestModel selectByTestId(Handle handle, Integer testId) {
		return handle.createQuery("SELECT * FROM anfelisa.test WHERE testId = :testId")
			.bind("testId", testId)
			.map(new TestMapper())
			.first();
	}
	
	public List<ITestModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.test")
			.map(new TestMapper())
			.list();
	}
}

/*       S.D.G.       */
