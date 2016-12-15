package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class CardDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".card (cardId serial NOT NULL  , content character varying  , testId integer NOT NULL  , contentHash character varying NOT NULL  , maxPoints integer NOT NULL  , CONSTRAINT card_pkey PRIMARY KEY (cardId), CONSTRAINT card_testId_fkey FOREIGN KEY (testId) REFERENCES " + schema + ".test ( testId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT card_cardId_unique UNIQUE (cardId))");
	}
	
	public static void insert(Handle handle, ICardModel cardModel, String schema) {
		if (cardModel.getCardId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".card (cardId, content, testId, contentHash, maxPoints) VALUES (:cardId, :content, :testId, :contentHash, :maxPoints)");
			statement.bind("cardId", cardModel.getCardId());
			statement.bind("content", cardModel.getContent());
			statement.bind("testId", cardModel.getTestId());
			statement.bind("contentHash", cardModel.getContentHash());
			statement.bind("maxPoints", cardModel.getMaxPoints());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".card_cardId_seq', (SELECT MAX(cardId) FROM " + schema + ".card));").execute();
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
		Update statement = handle.createStatement("UPDATE " + schema + ".card SET cardId = :cardId, content = :content, testId = :testId, contentHash = :contentHash, maxPoints = :maxPoints");
		statement.bind("cardId", cardModel.getCardId());
		statement.bind("content", cardModel.getContent());
		statement.bind("testId", cardModel.getTestId());
		statement.bind("contentHash", cardModel.getContentHash());
		statement.bind("maxPoints", cardModel.getMaxPoints());
		statement.execute();
	}
	
	public static void deleteByCardId(Handle handle, Integer cardId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".card WHERE cardId = :cardId");
		statement.bind("cardId", cardId);
		statement.execute();
	}

	public static ICardModel selectByCardId(Handle handle, Integer cardId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".card WHERE cardId = :cardId")
			.bind("cardId", cardId)
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
