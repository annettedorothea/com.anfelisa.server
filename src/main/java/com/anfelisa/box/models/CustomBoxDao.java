package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

public class CustomBoxDao {

	public static List<IBoxModel> selectByUsername(Handle handle, String schema, String username) {
		return handle.createQuery("SELECT * FROM " + schema + ".box where username = :username")
				.bind("username", username).map(new BoxMapper()).list();
	}

	public static List<ICardInfoModel> selectNextCardsByBoxId(Handle handle, String schema, Integer boxId) {
		return handle
				.createQuery("SELECT b.cardid, c.content, b.count, b.date, b.quality, bos.name, b.timestamp FROM "
						+ schema + ".cardofbox b INNER JOIN (SELECT cardid, MAX(count) as maxCount FROM " + schema
						+ ".cardofbox WHERE boxid = :boxId GROUP BY cardid ORDER BY cardid) latestCard ON b.cardid = latestCard.cardid AND b.count = latestCard.maxCount INNER JOIN "
						+ schema + ".card c ON c.cardid = b.cardid INNER JOIN " + schema
						+ ".box bos ON b.boxid = bos.boxid WHERE b.boxid = :boxId ORDER BY b.timestamp DESC")
				.bind("boxId", boxId).map(new CardInfoMapper()).list();
	}

	public static List<ICardOfBoxModel> selectCardsOfBoxForToday(Handle handle, String schema, Integer boxId) {
		return handle
				.createQuery("SELECT b.* FROM " + schema
						+ ".cardofbox b INNER JOIN (SELECT cardid, MAX(count) as maxCount FROM " + schema
						+ ".cardofbox WHERE boxid = :boxId GROUP BY cardid ORDER BY cardid) latestCard ON b.cardid = latestCard.cardid "
						+ "AND b.count = latestCard.maxCount AND date_trunc('day', b.date) <= date_trunc('day', now()) INNER JOIN "
						+ schema + ".card c ON c.cardid = b.cardid INNER JOIN " + schema
						+ ".box bos ON b.boxid = bos.boxid WHERE b.boxid = :boxId ORDER BY b.timestamp DESC")
				.bind("boxId", boxId).map(new CardOfBoxMapper()).list();
	}

	public static void updateBox(Handle handle, IBoxModel boxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".box SET name = :name WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.execute();
	}

	public static IBoxOfCourseModel selectBoxOfCourse(Handle handle, String schema, Integer courseId, String username, Integer boxId) {
		return handle
				.createQuery("SELECT bc.* FROM " + schema + ".boxofcourse bc INNER JOIN " + schema
						+ ".box b on bc.boxId = b.boxId WHERE bc.courseId = :courseId AND b.username = :username AND bc.boxId = :boxId")
				.bind("courseId", courseId)
				.bind("username", username)
				.bind("boxId", boxId)
				.map(new BoxOfCourseMapper())
				.first();
	}

}

/* S.D.G. */