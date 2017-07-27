package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class CardDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.card (cardid serial NOT NULL  , content character varying  , testid integer NOT NULL  , contenthash character varying NOT NULL  , maxpoints integer NOT NULL  , CONSTRAINT card_pkey PRIMARY KEY (cardid), CONSTRAINT card_testid_fkey FOREIGN KEY (testid) REFERENCES anfelisa.test ( testid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT card_cardId_unique UNIQUE (cardId))");
	}
	
	public Integer insert(Handle handle, ICardModel cardModel) {
		if (cardModel.getCardId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.card (cardid, content, testid, contenthash, maxpoints) VALUES (:cardid, :content, :testid, :contenthash, :maxpoints)");
			statement.bind("cardid",  cardModel.getCardId() );
			statement.bind("content",  cardModel.getContent() );
			statement.bind("testid",  cardModel.getTestId() );
			statement.bind("contenthash",  cardModel.getContentHash() );
			statement.bind("maxpoints",  cardModel.getMaxPoints() );
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.card_cardid_seq', (SELECT MAX(cardid) FROM anfelisa.card));").execute();
			return cardModel.getCardId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.card (content, testid, contenthash, maxpoints) VALUES (:content, :testid, :contenthash, :maxpoints) RETURNING cardid");
			statement.bind("content",  cardModel.getContent() );
			statement.bind("testid",  cardModel.getTestId() );
			statement.bind("contenthash",  cardModel.getContentHash() );
			statement.bind("maxpoints",  cardModel.getMaxPoints() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("cardid");
		}
	}
	
	
	public void updateByCardId(Handle handle, ICardModel cardModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.card SET cardid = :cardid, content = :content, testid = :testid, contenthash = :contenthash, maxpoints = :maxpoints WHERE cardid = :cardid");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("content",  cardModel.getContent() );
		statement.bind("testid",  cardModel.getTestId() );
		statement.bind("contenthash",  cardModel.getContentHash() );
		statement.bind("maxpoints",  cardModel.getMaxPoints() );
		statement.execute();
	}

	public void deleteByCardId(Handle handle, Integer cardId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.card WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(Handle handle, Integer cardId) {
		return handle.createQuery("SELECT * FROM anfelisa.card WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.first();
	}
	
	public List<ICardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.card")
			.map(new CardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE anfelisa.card");
		statement.execute();
	}

}

/*       S.D.G.       */
