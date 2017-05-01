package com.anfelisa.test.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class TestDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.test (testid serial NOT NULL  , name character varying NOT NULL  , sequence integer  , lessonid integer NOT NULL  , html character varying NOT NULL  , author character varying NOT NULL  , CONSTRAINT test_pkey PRIMARY KEY (testid), CONSTRAINT test_lessonid_fkey FOREIGN KEY (lessonid) REFERENCES anfelisa.lesson ( lessonid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_author_fkey FOREIGN KEY (author) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_testId_unique UNIQUE (testId))");
	}
	
	public Integer insert(Handle handle, ITestModel testModel) {
		if (testModel.getTestId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.test (testid, name, sequence, lessonid, html, author) VALUES (:testid, :name, :sequence, :lessonid, :html, :author)");
			statement.bind("testid",  testModel.getTestId() );
			statement.bind("name",  testModel.getName() );
			statement.bind("sequence",  testModel.getSequence() );
			statement.bind("lessonid",  testModel.getLessonId() );
			statement.bind("html",  testModel.getHtml() );
			statement.bind("author",  testModel.getAuthor() );
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.test_testid_seq', (SELECT MAX(testid) FROM anfelisa.test));").execute();
			return testModel.getTestId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.test (name, sequence, lessonid, html, author) VALUES (:name, :sequence, :lessonid, :html, :author) RETURNING testid");
			statement.bind("name",  testModel.getName() );
			statement.bind("sequence",  testModel.getSequence() );
			statement.bind("lessonid",  testModel.getLessonId() );
			statement.bind("html",  testModel.getHtml() );
			statement.bind("author",  testModel.getAuthor() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("testid");
		}
	}
	
	
	public void updateByTestId(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.test SET testid = :testid, name = :name, sequence = :sequence, lessonid = :lessonid, html = :html, author = :author WHERE testid = :testid");
		statement.bind("testid",  testModel.getTestId() );
		statement.bind("name",  testModel.getTestId() );
		statement.bind("sequence",  testModel.getTestId() );
		statement.bind("lessonid",  testModel.getTestId() );
		statement.bind("html",  testModel.getTestId() );
		statement.bind("author",  testModel.getTestId() );
		statement.execute();
	}

	public void deleteByTestId(Handle handle, Integer testId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.test WHERE testid = :testid");
		statement.bind("testid", testId);
		statement.execute();
	}

	public ITestModel selectByTestId(Handle handle, Integer testId) {
		return handle.createQuery("SELECT * FROM anfelisa.test WHERE testid = :testid")
			.bind("testid", testId)
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
