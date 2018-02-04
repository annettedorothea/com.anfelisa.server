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
	
	public Integer insert(Handle handle, ICardModel cardModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.card (content, testid, contenthash, maxpoints) VALUES (:content, :testid, :contenthash, :maxpoints) RETURNING cardid");
		statement.bind("content",  cardModel.getContent() );
		statement.bind("testid",  cardModel.getTestId() );
		statement.bind("contenthash",  cardModel.getContentHash() );
		statement.bind("maxpoints",  cardModel.getMaxPoints() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("cardid");
	}
	
	
	public void updateByCardId(Handle handle, ICardModel cardModel) {
		Update statement = handle.createStatement("UPDATE public.card SET content = :content, testid = :testid, contenthash = :contenthash, maxpoints = :maxpoints WHERE cardid = :cardid");
		statement.bind("content",  cardModel.getContent() );
		statement.bind("testid",  cardModel.getTestId() );
		statement.bind("contenthash",  cardModel.getContentHash() );
		statement.bind("maxpoints",  cardModel.getMaxPoints() );
		statement.bind("cardid",  cardModel.getCardId()  );
		statement.execute();
	}

	public void deleteByCardId(Handle handle, Integer cardId) {
		Update statement = handle.createStatement("DELETE FROM public.card WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(Handle handle, Integer cardId) {
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
		statement = handle.createStatement("ALTER SEQUENCE public.card_cardId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
