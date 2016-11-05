package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CardOfBoxDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".cardofbox (id serial NOT NULL , cardId integer NOT NULL , ef numeric , interval integer , count integer NOT NULL , date timestamp with time zone , boxId integer NOT NULL , quality integer , timestamp timestamp with time zone , points integer , CONSTRAINT cardofbox_pkey PRIMARY KEY (id), CONSTRAINT cardofbox_cardId_fkey FOREIGN KEY (cardId) REFERENCES " + schema + ".card ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT cardofbox_boxId_fkey FOREIGN KEY (boxId) REFERENCES " + schema + ".box ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT cardofbox_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ICardOfBoxModel cardOfBoxModel, String schema) {
		if (cardOfBoxModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".cardofbox (id, cardId, ef, interval, count, date, boxId, quality, timestamp, points) VALUES (:id, :cardId, :ef, :interval, :count, :date, :boxId, :quality, :timestamp, :points)");
			statement.bind("id", cardOfBoxModel.getId());
			statement.bind("cardId", cardOfBoxModel.getCardId());
			statement.bind("ef", cardOfBoxModel.getEf());
			statement.bind("interval", cardOfBoxModel.getInterval());
			statement.bind("count", cardOfBoxModel.getCount());
			statement.bind("date", cardOfBoxModel.getDate());
			statement.bind("boxId", cardOfBoxModel.getBoxId());
			statement.bind("quality", cardOfBoxModel.getQuality());
			statement.bind("timestamp", cardOfBoxModel.getTimestamp());
			statement.bind("points", cardOfBoxModel.getPoints());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".cardofbox (cardId, ef, interval, count, date, boxId, quality, timestamp, points) VALUES (:cardId, :ef, :interval, :count, :date, :boxId, :quality, :timestamp, :points)");
			statement.bind("cardId", cardOfBoxModel.getCardId());
			statement.bind("ef", cardOfBoxModel.getEf());
			statement.bind("interval", cardOfBoxModel.getInterval());
			statement.bind("count", cardOfBoxModel.getCount());
			statement.bind("date", cardOfBoxModel.getDate());
			statement.bind("boxId", cardOfBoxModel.getBoxId());
			statement.bind("quality", cardOfBoxModel.getQuality());
			statement.bind("timestamp", cardOfBoxModel.getTimestamp());
			statement.bind("points", cardOfBoxModel.getPoints());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ICardOfBoxModel cardOfBoxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".cardofbox SET id = :id, cardId = :cardId, ef = :ef, interval = :interval, count = :count, date = :date, boxId = :boxId, quality = :quality, timestamp = :timestamp, points = :points");
		statement.bind("id", cardOfBoxModel.getId());
		statement.bind("cardId", cardOfBoxModel.getCardId());
		statement.bind("ef", cardOfBoxModel.getEf());
		statement.bind("interval", cardOfBoxModel.getInterval());
		statement.bind("count", cardOfBoxModel.getCount());
		statement.bind("date", cardOfBoxModel.getDate());
		statement.bind("boxId", cardOfBoxModel.getBoxId());
		statement.bind("quality", cardOfBoxModel.getQuality());
		statement.bind("timestamp", cardOfBoxModel.getTimestamp());
		statement.bind("points", cardOfBoxModel.getPoints());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".cardofbox WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ICardOfBoxModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".cardofbox WHERE id = :id")
			.bind("id", id)
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
