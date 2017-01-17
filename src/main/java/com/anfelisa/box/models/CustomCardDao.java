package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomCardDao {

	public List<ICardModel> selectCardsOfCourseThatAreNotAlreadyInBox(Handle handle, String schema,
			Integer courseId, Integer boxId) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".card c INNER JOIN " + schema
						+ ".test t on c.testId = t.testId INNER JOIN " + schema
						+ ".lesson l on t.lessonId = l.lessonId WHERE l.courseId = :courseId EXCEPT SELECT DISTINCT c.* FROM "
						+ schema + ".card c INNER JOIN " + schema
						+ ".ScheduledCard cb on c.cardId = cb.cardId WHERE cb.boxId = :boxId")
				.bind("courseId", courseId).bind("boxId", boxId).map(new CardMapper()).list();
	}

	public List<ICardModel> selectCardsOfCourseThatAreNotAlreadyInBoxAndHaveResult(Handle handle, String schema,
			Integer courseId, Integer boxId, String username) {
		return handle
				.createQuery("SELECT c.* FROM " + schema + ".result r, " + schema + ".card c INNER JOIN " + schema
						+ ".test t on c.testId = t.testId INNER JOIN " + schema
						+ ".lesson l on t.lessonId = l.lessonId WHERE l.courseId = :courseId AND r.testId = t.testId AND r.username = :username EXCEPT SELECT DISTINCT c.* FROM "
						+ schema + ".card c INNER JOIN " + schema
						+ ".ScheduledCard cb on c.cardId = cb.cardId WHERE cb.boxId = :boxId")
				.bind("courseId", courseId).bind("boxId", boxId).bind("username", username).map(new CardMapper())
				.list();
	}

	public void deleteByHash(Handle handle, String schema, String contentHash) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".card WHERE contentHash = :contentHash");
		statement.bind("contentHash", contentHash);
		statement.execute();
	}

	public List<ICardModel> selectByTestId(Handle handle, String schema, Integer testId) {
		return handle.createQuery("SELECT * FROM " + schema + ".card WHERE testId = :testId").bind("testId", testId)
				.map(new CardMapper()).list();
	}

	public ICardModel selectByTestIdAndContentHash(Handle handle, String schema, Integer testId,
			String contentHash) {
		return handle
				.createQuery("SELECT * FROM " + schema + ".card WHERE testId = :testId AND contentHash = :contentHash")
				.bind("testId", testId).bind("contentHash", contentHash).map(new CardMapper()).first();
	}

	public List<ICardModel> selectCardsToBeAddedAfterEdit(Handle handle, String schema, Integer testId,
			Integer boxId) {
		return handle
				.createQuery("SELECT DISTINCT c.* FROM " + schema + ".card c INNER JOIN " + schema
						+ ".test t on c.testId = t.testId INNER JOIN " + schema
						+ ".lesson l on t.lessonId = l.lessonId WHERE t.testId = :testId EXCEPT SELECT DISTINCT c.* FROM "
						+ schema + ".card c INNER JOIN " + schema
						+ ".ScheduledCard cb on c.cardId = cb.cardId WHERE cb.boxId = :boxId")
				.bind("testId", testId).bind("boxId", boxId).map(new CardMapper()).list();
	}

}
