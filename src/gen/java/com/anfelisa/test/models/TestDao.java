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
		handle.execute("CREATE TABLE IF NOT EXISTS public.test (testid integer NOT NULL  , name character varying NOT NULL  , sequence integer  , lessonid integer NOT NULL  , html character varying NOT NULL  , author character varying NOT NULL  , CONSTRAINT test_pkey PRIMARY KEY (testid), CONSTRAINT test_lessonid_fkey FOREIGN KEY (lessonid) REFERENCES public.lesson ( lessonid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_author_fkey FOREIGN KEY (author) REFERENCES public.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT test_testId_unique UNIQUE (testId))");
	}
	
	public Integer insert(Handle handle, ITestModel testModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.test (testid, name, sequence, lessonid, html, author) VALUES ( (SELECT COALESCE(MAX(testid),0) + 1 FROM public.test), :name, :sequence, :lessonid, :html, :author) RETURNING testid");
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("testid");
	}
	
	
	public void updateByTestId(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("UPDATE public.test SET testid = :testid, name = :name, sequence = :sequence, lessonid = :lessonid, html = :html, author = :author WHERE testid = :testid");
		statement.bind("testid",  testModel.getTestId() );
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		statement.execute();
	}

	public void deleteByTestId(Handle handle, Integer testId) {
		Update statement = handle.createStatement("DELETE FROM public.test WHERE testid = :testid");
		statement.bind("testid", testId);
		statement.execute();
	}

	public ITestModel selectByTestId(Handle handle, Integer testId) {
		return handle.createQuery("SELECT * FROM public.test WHERE testid = :testid")
			.bind("testid", testId)
			.map(new TestMapper())
			.first();
	}
	
	public List<ITestModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.test")
			.map(new TestMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.test");
		statement.execute();
	}

}

/*       S.D.G.       */
