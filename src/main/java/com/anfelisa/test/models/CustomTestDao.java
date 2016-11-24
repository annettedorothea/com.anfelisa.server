package com.anfelisa.test.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomTestDao {

	public static List<ITestModel> selectTests(Handle handle, String schema, Integer lessonId) {
		return handle.createQuery("SELECT * FROM " + schema + ".test WHERE lessonId = :lessonId ORDER By sequence")
			.bind("lessonId", lessonId)
			.map(new TestMapper())
			.list();
	}

}
