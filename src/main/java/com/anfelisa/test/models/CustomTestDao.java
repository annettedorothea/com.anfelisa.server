package com.anfelisa.test.models;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.result.models.CustomResultDao;
import com.anfelisa.result.models.IResultAbstractModel;

public class CustomTestDao {

	private CustomResultDao customResultDao = new CustomResultDao();

	public List<ITestModel> selectTests(Handle handle, Integer lessonId) {
		return handle.createQuery("SELECT * FROM anfelisa.test WHERE lessonId = :lessonId ORDER By sequence")
				.bind("lessonId", lessonId).map(new TestMapper()).list();
	}

	public List<IMyTestModel> selectMyTests(Handle handle, Integer lessonId, String username) {
		List<ITestModel> tests = this.selectTests(handle, lessonId);
		List<IMyTestModel> list = new ArrayList<IMyTestModel>();
		for (ITestModel test : tests) {
			MyTestModel myTest = new MyTestModel(test.getTestId(), test.getName(), test.getSequence(), 0, false);
			List<IResultAbstractModel> results = customResultDao.selectByTestIdAndUsername(handle, test.getTestId(),
					username);
			myTest.setResultAbstractList(results);
			myTest.setHasResults(results.size() > 0);
			myTest.setResultCount(results.size());
			list.add(myTest);
		}
		return list;
	}

	public ITestModel selectByTestIdAndUsername(Handle handle, Integer testId, String username) {
		return handle
				.createQuery(
						"SELECT t.* FROM anfelisa.course c, anfelisa.studentofcourse sc, anfelisa.lesson l, anfelisa.test t "
								+ "WHERE t.testId = :testId AND t.lessonId = l.lessonId AND l.courseId = c.courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("testId", testId).bind("username", username).map(new TestMapper()).first();

	}

}
