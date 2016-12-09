package com.anfelisa.test.models;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.result.models.CustomResultDao;
import com.anfelisa.result.models.IResultAbstractModel;

public class CustomTestDao {

	public static List<ITestModel> selectTests(Handle handle, String schema, Integer lessonId) {
		return handle.createQuery("SELECT * FROM " + schema + ".test WHERE lessonId = :lessonId ORDER By sequence")
				.bind("lessonId", lessonId).map(new TestMapper()).list();
	}

	public static List<IMyTestModel> selectMyTests(Handle handle, String schema, Integer lessonId, String username) {
		List<ITestModel> tests = CustomTestDao.selectTests(handle,
				schema, lessonId);
		List<IMyTestModel> list = new ArrayList<IMyTestModel>();
		for (ITestModel test : tests) {
			MyTestModel myTest = new MyTestModel(test.getTestId(), test.getName(), test.getSequence(), 0, false);
			List<IResultAbstractModel> results = CustomResultDao.selectByTestIdAndUsername(handle, schema, test.getTestId(), username);
			myTest.setResultAbstractList(results);
			myTest.setHasResults(results.size() > 0);
			myTest.setResultCount(results.size());
			list.add(myTest);
		}
		return list;
	}

	public static ITestModel selectByTestIdAndUsername(Handle handle, Integer testId, String username, String schema) {
		return handle
				.createQuery("SELECT t.* FROM " + schema + ".course c, " + schema + ".studentofcourse sc, " + schema
						+ ".lesson l, " + schema
						+ ".test t WHERE t.testId = :testId AND t.lessonId = l.lessonId AND l.courseId = c.courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("testId", testId).bind("username", username).map(new TestMapper()).first();

	}

}
