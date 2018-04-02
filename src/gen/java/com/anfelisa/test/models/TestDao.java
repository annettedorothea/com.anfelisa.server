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
	
	public void insert(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("INSERT INTO public.test (testid, name, sequence, lessonid, html, author) VALUES (:testid, :name, :sequence, :lessonid, :html, :author)");
		statement.bind("testid",  testModel.getTestId() );
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		statement.execute();
	}
	
	
	public void updateByTestId(Handle handle, ITestModel testModel) {
		Update statement = handle.createStatement("UPDATE public.test SET testid = :testid, name = :name, sequence = :sequence, lessonid = :lessonid, html = :html, author = :author WHERE testid = :testid");
		statement.bind("testid",  testModel.getTestId() );
		statement.bind("name",  testModel.getName() );
		statement.bind("sequence",  testModel.getSequence() );
		statement.bind("lessonid",  testModel.getLessonId() );
		statement.bind("html",  testModel.getHtml() );
		statement.bind("author",  testModel.getAuthor() );
		statement.bind("testid",  testModel.getTestId()  );
		statement.execute();
	}

	public void deleteByTestId(Handle handle, String testId) {
		Update statement = handle.createStatement("DELETE FROM public.test WHERE testid = :testid");
		statement.bind("testid", testId);
		statement.execute();
	}

	public ITestModel selectByTestId(Handle handle, String testId) {
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
	}

}

/*       S.D.G.       */
