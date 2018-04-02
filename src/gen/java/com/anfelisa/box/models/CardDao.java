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
	
	public void insert(Handle handle, ICardModel cardModel) {
		Update statement = handle.createStatement("INSERT INTO public.card (cardid, content, testid, contenthash, maxpoints) VALUES (:cardid, :content, :testid, :contenthash, :maxpoints)");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("content",  cardModel.getContent() );
		statement.bind("testid",  cardModel.getTestId() );
		statement.bind("contenthash",  cardModel.getContentHash() );
		statement.bind("maxpoints",  cardModel.getMaxPoints() );
		statement.execute();
	}
	
	
	public void updateByCardId(Handle handle, ICardModel cardModel) {
		Update statement = handle.createStatement("UPDATE public.card SET cardid = :cardid, content = :content, testid = :testid, contenthash = :contenthash, maxpoints = :maxpoints WHERE cardid = :cardid");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("content",  cardModel.getContent() );
		statement.bind("testid",  cardModel.getTestId() );
		statement.bind("contenthash",  cardModel.getContentHash() );
		statement.bind("maxpoints",  cardModel.getMaxPoints() );
		statement.bind("cardid",  cardModel.getCardId()  );
		statement.execute();
	}

	public void deleteByCardId(Handle handle, String cardId) {
		Update statement = handle.createStatement("DELETE FROM public.card WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(Handle handle, String cardId) {
		return handle.createQuery("SELECT cardid, content, testid, contenthash, maxpoints FROM public.card WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.first();
	}
	
	public List<ICardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT cardid, content, testid, contenthash, maxpoints FROM public.card")
			.map(new CardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.card CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
