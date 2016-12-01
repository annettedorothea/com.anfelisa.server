package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomBoxDao {

	public static List<IBoxModel> selectByUsername(Handle handle, String schema, String username) {
		return handle.createQuery("SELECT * FROM " + schema + ".box where username = :username")
				.bind("username", username).map(new BoxMapper()).list();
	}

	public static List<ICardInfoModel> selectNextCardsByBoxId(Handle handle, String schema, Integer boxId) {
		return handle
				.createQuery("SELECT b.cardid, c.content, b.count, b.date, b.quality, bos.name, b.timestamp FROM "
						+ schema + ".cardofbox b INNER JOIN (SELECT cardid, MAX(count) as maxCount FROM " + schema
						+ ".cardofbox WHERE boxid = 11 GROUP BY cardid ORDER BY cardid) latestCard ON b.cardid = latestCard.cardid AND b.count = latestCard.maxCount INNER JOIN "
						+ schema + ".card c ON c.cardid = b.cardid INNER JOIN " + schema
						+ ".box bos ON b.boxid = bos.boxid WHERE b.boxid = 11 ORDER BY b.timestamp DESC")
				.bind("boxId", boxId).map(new CardInfoMapper()).list();
	}
}

/* S.D.G. */
