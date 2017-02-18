package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ScheduledCardDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.scheduledcard (scheduledCardId serial NOT NULL  , cardId integer NOT NULL  , ef numeric NOT NULL  , interval integer  , n integer NOT NULL  , count integer NOT NULL  , scheduledDate timestamp with time zone NOT NULL  , boxId integer NOT NULL  , lastQuality integer  , timestamp timestamp with time zone NOT NULL  , removed boolean NOT NULL  , CONSTRAINT scheduledcard_pkey PRIMARY KEY (scheduledCardId), CONSTRAINT scheduledcard_cardId_fkey FOREIGN KEY (cardId) REFERENCES anfelisa.card ( cardId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scheduledcard_boxId_fkey FOREIGN KEY (boxId) REFERENCES anfelisa.box ( boxId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT scheduledcard_scheduledCardId_unique UNIQUE (scheduledCardId))");
	}
	
	public Integer insert(Handle handle, IScheduledCardModel scheduledCardModel) {
		if (scheduledCardModel.getScheduledCardId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.scheduledcard (scheduledCardId, cardId, ef, interval, n, count, scheduledDate, boxId, lastQuality, timestamp, removed) VALUES (:scheduledCardId, :cardId, :ef, :interval, :n, :count, :scheduledDate, :boxId, :lastQuality, :timestamp, :removed)");
			statement.bind("scheduledCardId", scheduledCardModel.getScheduledCardId());
			statement.bind("cardId", scheduledCardModel.getCardId());
			statement.bind("ef", scheduledCardModel.getEf());
			statement.bind("interval", scheduledCardModel.getInterval());
			statement.bind("n", scheduledCardModel.getN());
			statement.bind("count", scheduledCardModel.getCount());
			statement.bind("scheduledDate", scheduledCardModel.getScheduledDate());
			statement.bind("boxId", scheduledCardModel.getBoxId());
			statement.bind("lastQuality", scheduledCardModel.getLastQuality());
			statement.bind("timestamp", scheduledCardModel.getTimestamp());
			statement.bind("removed", scheduledCardModel.getRemoved());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.scheduledcard_scheduledCardId_seq', (SELECT MAX(scheduledCardId) FROM anfelisa.scheduledcard));").execute();
			return scheduledCardModel.getScheduledCardId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.scheduledcard (cardId, ef, interval, n, count, scheduledDate, boxId, lastQuality, timestamp, removed) VALUES (:cardId, :ef, :interval, :n, :count, :scheduledDate, :boxId, :lastQuality, :timestamp, :removed) RETURNING scheduledCardId");
			statement.bind("cardId", scheduledCardModel.getCardId());
			statement.bind("ef", scheduledCardModel.getEf());
			statement.bind("interval", scheduledCardModel.getInterval());
			statement.bind("n", scheduledCardModel.getN());
			statement.bind("count", scheduledCardModel.getCount());
			statement.bind("scheduledDate", scheduledCardModel.getScheduledDate());
			statement.bind("boxId", scheduledCardModel.getBoxId());
			statement.bind("lastQuality", scheduledCardModel.getLastQuality());
			statement.bind("timestamp", scheduledCardModel.getTimestamp());
			statement.bind("removed", scheduledCardModel.getRemoved());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("scheduledCardId");
		}
	}
	
	
	public void updateByScheduledCardId(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.scheduledcard SET scheduledCardId = :scheduledCardId, cardId = :cardId, ef = :ef, interval = :interval, n = :n, count = :count, scheduledDate = :scheduledDate, boxId = :boxId, lastQuality = :lastQuality, timestamp = :timestamp, removed = :removed WHERE scheduledCardId = :scheduledCardId");
		statement.bind("scheduledCardId", scheduledCardModel.getScheduledCardId());
		statement.bind("cardId", scheduledCardModel.getCardId());
		statement.bind("ef", scheduledCardModel.getEf());
		statement.bind("interval", scheduledCardModel.getInterval());
		statement.bind("n", scheduledCardModel.getN());
		statement.bind("count", scheduledCardModel.getCount());
		statement.bind("scheduledDate", scheduledCardModel.getScheduledDate());
		statement.bind("boxId", scheduledCardModel.getBoxId());
		statement.bind("lastQuality", scheduledCardModel.getLastQuality());
		statement.bind("timestamp", scheduledCardModel.getTimestamp());
		statement.bind("removed", scheduledCardModel.getRemoved());
		statement.execute();
	}

	public void deleteByScheduledCardId(Handle handle, Integer scheduledCardId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.scheduledcard WHERE scheduledCardId = :scheduledCardId");
		statement.bind("scheduledCardId", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(Handle handle, Integer scheduledCardId) {
		return handle.createQuery("SELECT * FROM anfelisa.scheduledcard WHERE scheduledCardId = :scheduledCardId")
			.bind("scheduledCardId", scheduledCardId)
			.map(new ScheduledCardMapper())
			.first();
	}
	
	public List<IScheduledCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.scheduledcard")
			.map(new ScheduledCardMapper())
			.list();
	}
}

/*       S.D.G.       */
