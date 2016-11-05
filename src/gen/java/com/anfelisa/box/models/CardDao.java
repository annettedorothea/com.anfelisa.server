package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CardDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".card (id serial NOT NULL , content character varying , testId integer NOT NULL , contentHash character varying NOT NULL , maxPoints integer NOT NULL , CONSTRAINT card_pkey PRIMARY KEY (id), CONSTRAINT card_testId_fkey FOREIGN KEY (testId) REFERENCES " + schema + ".test ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT card_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ICardModel cardModel, String schema) {
		if (cardModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".card (id, content, testId, contentHash, maxPoints) VALUES (:id, :content, :testId, :contentHash, :maxPoints)");
			statement.bind("id", cardModel.getId());
			statement.bind("content", cardModel.getContent());
			statement.bind("testId", cardModel.getTestId());
			statement.bind("contentHash", cardModel.getContentHash());
			statement.bind("maxPoints", cardModel.getMaxPoints());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".card (content, testId, contentHash, maxPoints) VALUES (:content, :testId, :contentHash, :maxPoints)");
			statement.bind("content", cardModel.getContent());
			statement.bind("testId", cardModel.getTestId());
			statement.bind("contentHash", cardModel.getContentHash());
			statement.bind("maxPoints", cardModel.getMaxPoints());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ICardModel cardModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".card SET id = :id, content = :content, testId = :testId, contentHash = :contentHash, maxPoints = :maxPoints");
		statement.bind("id", cardModel.getId());
		statement.bind("content", cardModel.getContent());
		statement.bind("testId", cardModel.getTestId());
		statement.bind("contentHash", cardModel.getContentHash());
		statement.bind("maxPoints", cardModel.getMaxPoints());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".card WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ICardModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".card WHERE id = :id")
			.bind("id", id)
			.map(new CardMapper())
			.first();
	}
	
	public static List<ICardModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".card")
			.map(new CardMapper())
			.list();
	}
}

/*       S.D.G.       */
