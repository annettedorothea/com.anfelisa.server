package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class CardDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.card (cardId serial NOT NULL  , content character varying  , testId integer NOT NULL  , contentHash character varying NOT NULL  , maxPoints integer NOT NULL  , CONSTRAINT card_pkey PRIMARY KEY (cardId), CONSTRAINT card_testId_fkey FOREIGN KEY (testId) REFERENCES anfelisa.test ( testId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT card_cardId_unique UNIQUE (cardId))");
	}
	
	public Integer insert(Handle handle, ICardModel cardModel) {
		if (cardModel.getCardId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.card (cardId, content, testId, contentHash, maxPoints) VALUES (:cardId, :content, :testId, :contentHash, :maxPoints)");
			statement.bind("cardId", cardModel.getCardId());
			statement.bind("content", cardModel.getContent());
			statement.bind("testId", cardModel.getTestId());
			statement.bind("contentHash", cardModel.getContentHash());
			statement.bind("maxPoints", cardModel.getMaxPoints());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.card_cardId_seq', (SELECT MAX(cardId) FROM anfelisa.card));").execute();
			return cardModel.getCardId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.card (content, testId, contentHash, maxPoints) VALUES (:content, :testId, :contentHash, :maxPoints) RETURNING cardId");
			statement.bind("content", cardModel.getContent());
			statement.bind("testId", cardModel.getTestId());
			statement.bind("contentHash", cardModel.getContentHash());
			statement.bind("maxPoints", cardModel.getMaxPoints());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("cardId");
		}
	}
	
	
	public void updateByCardId(Handle handle, ICardModel cardModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.card SET cardId = :cardId, content = :content, testId = :testId, contentHash = :contentHash, maxPoints = :maxPoints WHERE cardId = :cardId");
		statement.bind("cardId", cardModel.getCardId());
		statement.bind("content", cardModel.getContent());
		statement.bind("testId", cardModel.getTestId());
		statement.bind("contentHash", cardModel.getContentHash());
		statement.bind("maxPoints", cardModel.getMaxPoints());
		statement.execute();
	}

	public void deleteByCardId(Handle handle, Integer cardId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.card WHERE cardId = :cardId");
		statement.bind("cardId", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(Handle handle, Integer cardId) {
		return handle.createQuery("SELECT * FROM anfelisa.card WHERE cardId = :cardId")
			.bind("cardId", cardId)
			.map(new CardMapper())
			.first();
	}
	
	public List<ICardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.card")
			.map(new CardMapper())
			.list();
	}
}

/*       S.D.G.       */
