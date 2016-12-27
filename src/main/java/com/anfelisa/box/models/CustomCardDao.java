package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomCardDao {

	public static List<ICardModel> selectCardsOfCourseThatAreNotAlreadyInBox(Handle handle, String schema, Integer courseId, Integer boxId) {
		return handle.createQuery("SELECT c.* FROM " + schema + ".card c INNER JOIN " + schema
				+ ".test t on c.testId = t.testId INNER JOIN " + schema
				+ ".lesson l on t.lessonId = l.lessonId WHERE l.courseId = :courseId EXCEPT SELECT DISTINCT c.* FROM "
				+ schema + ".card c INNER JOIN " + schema + ".cardofbox cb on c.cardId = cb.cardId WHERE cb.boxId = :boxId")
				.bind("courseId", courseId)
				.bind("boxId", boxId)
				.map(new CardMapper()).list();
	}
}
