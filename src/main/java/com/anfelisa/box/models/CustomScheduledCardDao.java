package com.anfelisa.box.models;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class CustomScheduledCardDao {

	public INextCardModel selectFirstScheduledCard(Handle handle, String boxId, DateTime today) {
		return handle.createQuery(
				"SELECT sc.scheduledcardid, c.cardid, sc.scheduleddate, sc.boxid, sc.lastquality, c.given, c.wanted, c.image, c.categoryid, sc.count, sc.scoreddate FROM public.scheduledcard sc "
						+ "inner join public.card c on c.cardid = sc.cardid "
						+ "inner join public.category ct on c.categoryid = ct.categoryid "
						+ "WHERE sc.boxid = :boxId AND sc.removed = false and sc.scheduleddate < :today order by sc.scheduleddate, ct.categoryindex, c.cardindex limit 1")
				.bind("boxId", boxId)
				.bind("today", today)
				.map(new NextCardMapper()).first();
	}

	public List<IScheduledCardModel> selectReinforceCards(Handle handle, String boxId, DateTime now) {
		return handle.createQuery(
				"SELECT scheduledcardid, cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp, removed FROM public.scheduledcard WHERE boxid = :boxId AND removed = false AND lastquality < 4 AND date_trunc('day', timestamp) >= date_trunc('day', TIMESTAMP ':now') ORDER BY timestamp ASC")
				.bind("boxId", boxId).bind("now", now.toString()).map(new ScheduledCardMapper()).list();
	}

	public void postponeScheduledCards(Handle handle, String boxId, Integer daysBehind) {
		Update statement = handle
				.createStatement("UPDATE public.scheduledcard SET scheduleddate = scheduleddate + INTERVAL '"
						+ daysBehind + " days' WHERE boxid = :boxId");
		statement.bind("boxId", boxId);
		statement.execute();
	}

	public String selectNextCardId(Handle handle, String categoryId, String boxId) {
		return handle.createQuery(
				"select cardid from (SELECT cardid, cardindex from public.card where categoryid = :categoryid "
				+ "except select c.cardid, c.cardindex FROM public.scheduledcard sc inner join card c on c.cardid = sc.cardid where sc.boxid = :boxid order by cardindex) as cards limit 1")
				.bind("categoryid", categoryId).bind("boxid", boxId).mapTo(String.class).first();
	}
}
