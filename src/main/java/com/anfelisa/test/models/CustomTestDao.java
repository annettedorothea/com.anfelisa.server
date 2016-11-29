package com.anfelisa.test.models;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.result.models.ResultAbstractModel;

public class CustomTestDao {

	public static List<ITestModel> selectTests(Handle handle, String schema, Integer lessonId) {
		return handle.createQuery("SELECT * FROM " + schema + ".test WHERE lessonId = :lessonId ORDER By sequence")
				.bind("lessonId", lessonId).map(new TestMapper()).list();
	}

	public static List<IMyTestModel> selectMyTests(Handle handle, String schema, Integer lessonId, String username) {
		List<TestJoinedToResult> result = handle
				.createQuery("SELECT *, r.id as resultId FROM " + schema + ".test t left outer join " + schema
						+ ".result r ON r.testId = t.id WHERE t.lessonId = :lessonId AND (r.username = :username OR r.username IS NULL) ORDER By t.sequence, r.date")
				.bind("lessonId", lessonId).bind("username", username).map(new TestJoinedToResultMapper()).list();
		ArrayList<IMyTestModel> list = new ArrayList<IMyTestModel>();
		Integer lastTestId = -1;
		MyTestModel current = null;
		for (TestJoinedToResult testJoinedToResult : result) {
			if (lastTestId != testJoinedToResult.getId()) {
				if (current != null) {
					current.setResultCount(current.getResultAbstractList().size());
					current.setHasResults(current.getResultCount() > 0);
				}
				current = new MyTestModel(testJoinedToResult.getId(), testJoinedToResult.getName(),
						testJoinedToResult.getSequence(), testJoinedToResult.getResultCount(),
						testJoinedToResult.getHasResults());
				current.setResultAbstractList(new ArrayList<>());
				list.add(current);
			}
			if (current != null && testJoinedToResult.getResultId() != null) {
				ResultAbstractModel resultModel = new ResultAbstractModel(testJoinedToResult.getResultId(),
						testJoinedToResult.getDate(), testJoinedToResult.getPoints(),
						testJoinedToResult.getMaxPoints());
				current.getResultAbstractList().add(resultModel);
			}
		}
		return list;
	}

	public static ITestModel selectByTestIdAndUsername(Handle handle, Integer testId, String username, String schema) {
		return handle
				.createQuery("SELECT t.* FROM " + schema + ".course c, " + schema + ".studentofcourse sc, " + schema
						+ ".lesson l, " + schema
						+ ".test t WHERE t.id = :testId AND t.lessonId = l.id AND l.courseId = c.id AND sc.courseId = c.id AND sc.username = :username")
				.bind("testId", testId).bind("username", username).map(new TestMapper()).first();

	}

}
