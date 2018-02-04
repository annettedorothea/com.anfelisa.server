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
	
	public Integer insert(Handle handle, ITestModel testModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.test (name, sequence, lessonid, html, author) VALUES (:name, :sequence, :lessonid, :html, :author) RETURNING testid");
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("testid");
	}
	
	
	public void updateByTestId(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("UPDATE public.test SET name = :name, sequence = :sequence, lessonid = :lessonid, html = :html, author = :author WHERE testid = :testid");
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		statement.bind("testid",  testModel.getTestId()  );
		statement.execute();
	}

	public void deleteByTestId(Handle handle, Integer testId) {
		Update statement = handle.createStatement("DELETE FROM public.test WHERE testid = :testid");
		statement.bind("testid", testId);
		statement.execute();
	}

	public ITestModel selectByTestId(Handle handle, Integer testId) {
		return handle.createQuery("SELECT testid, name, sequence, lessonid, html, author FROM public.test WHERE testid = :testid")
			.bind("testid", testId)
			.map(new TestMapper())
			.first();
	}
	
	public List<ITestModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT testid, name, sequence, lessonid, html, author FROM public.test")
			.map(new TestMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.test CASCADE");
		statement.execute();
		statement = handle.createStatement("ALTER SEQUENCE public.test_testId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
