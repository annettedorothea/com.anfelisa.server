package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CardOfBoxDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".cardofbox (cardOfBoxId serial NOT NULL  , cardId integer NOT NULL  , ef numeric  , interval integer  , n integer  , count integer NOT NULL  , date timestamp with time zone  , boxId integer NOT NULL  , quality integer  , timestamp timestamp with time zone  , points integer  , CONSTRAINT cardofbox_pkey PRIMARY KEY (cardOfBoxId), CONSTRAINT cardofbox_cardId_fkey FOREIGN KEY (cardId) REFERENCES " + schema + ".card ( cardId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT cardofbox_boxId_fkey FOREIGN KEY (boxId) REFERENCES " + schema + ".box ( boxId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT cardofbox_cardOfBoxId_unique UNIQUE (cardOfBoxId))");
	}
	
	public static void insert(Handle handle, ICardOfBoxModel cardOfBoxModel, String schema) {
		if (cardOfBoxModel.getCardOfBoxId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".cardofbox (cardOfBoxId, cardId, ef, interval, n, count, date, boxId, quality, timestamp, points) VALUES (:cardOfBoxId, :cardId, :ef, :interval, :n, :count, :date, :boxId, :quality, :timestamp, :points)");
			statement.bind("cardOfBoxId", cardOfBoxModel.getCardOfBoxId());
			statement.bind("cardId", cardOfBoxModel.getCardId());
			statement.bind("ef", cardOfBoxModel.getEf());
			statement.bind("interval", cardOfBoxModel.getInterval());
			statement.bind("n", cardOfBoxModel.getN());
			statement.bind("count", cardOfBoxModel.getCount());
			statement.bind("date", cardOfBoxModel.getDate());
			statement.bind("boxId", cardOfBoxModel.getBoxId());
			statement.bind("quality", cardOfBoxModel.getQuality());
			statement.bind("timestamp", cardOfBoxModel.getTimestamp());
			statement.bind("points", cardOfBoxModel.getPoints());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".cardofbox_cardOfBoxId_seq', (SELECT MAX(cardOfBoxId) FROM " + schema + ".cardofbox));").execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".cardofbox (cardId, ef, interval, n, count, date, boxId, quality, timestamp, points) VALUES (:cardId, :ef, :interval, :n, :count, :date, :boxId, :quality, :timestamp, :points)");
			statement.bind("cardId", cardOfBoxModel.getCardId());
			statement.bind("ef", cardOfBoxModel.getEf());
			statement.bind("interval", cardOfBoxModel.getInterval());
			statement.bind("n", cardOfBoxModel.getN());
			statement.bind("count", cardOfBoxModel.getCount());
			statement.bind("date", cardOfBoxModel.getDate());
			statement.bind("boxId", cardOfBoxModel.getBoxId());
			statement.bind("quality", cardOfBoxModel.getQuality());
			statement.bind("timestamp", cardOfBoxModel.getTimestamp());
			statement.bind("points", cardOfBoxModel.getPoints());
			statement.execute();
		}
	}
	
	
	public static void updateByCardOfBoxId(Handle handle, ICardOfBoxModel cardOfBoxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".cardofbox SET cardOfBoxId = :cardOfBoxId, cardId = :cardId, ef = :ef, interval = :interval, n = :n, count = :count, date = :date, boxId = :boxId, quality = :quality, timestamp = :timestamp, points = :points WHERE cardOfBoxId = :cardOfBoxId");
		statement.bind("cardOfBoxId", cardOfBoxModel.getCardOfBoxId());
		statement.bind("cardId", cardOfBoxModel.getCardOfBoxId());
		statement.bind("ef", cardOfBoxModel.getCardOfBoxId());
		statement.bind("interval", cardOfBoxModel.getCardOfBoxId());
		statement.bind("n", cardOfBoxModel.getCardOfBoxId());
		statement.bind("count", cardOfBoxModel.getCardOfBoxId());
		statement.bind("date", cardOfBoxModel.getCardOfBoxId());
		statement.bind("boxId", cardOfBoxModel.getCardOfBoxId());
		statement.bind("quality", cardOfBoxModel.getCardOfBoxId());
		statement.bind("timestamp", cardOfBoxModel.getCardOfBoxId());
		statement.bind("points", cardOfBoxModel.getCardOfBoxId());
		statement.execute();
	}

	public static void deleteByCardOfBoxId(Handle handle, Integer cardOfBoxId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".cardofbox WHERE cardOfBoxId = :cardOfBoxId");
		statement.bind("cardOfBoxId", cardOfBoxId);
		statement.execute();
	}

	public static ICardOfBoxModel selectByCardOfBoxId(Handle handle, Integer cardOfBoxId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".cardofbox WHERE cardOfBoxId = :cardOfBoxId")
			.bind("cardOfBoxId", cardOfBoxId)
			.map(new CardOfBoxMapper())
			.first();
	}
	
	public static List<ICardOfBoxModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".cardofbox")
			.map(new CardOfBoxMapper())
			.list();
	}
}

/*       S.D.G.       */
