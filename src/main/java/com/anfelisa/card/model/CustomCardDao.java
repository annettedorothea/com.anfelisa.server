package com.anfelisa.card.model;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.models.CardMapper;
import com.anfelisa.card.models.ICardModel;


public class CustomCardDao {

	public List<ICardModel> selectAllOfCategory(Handle handle, String categoryId) {
		return handle.createQuery("SELECT cardid, given, wanted, cardauthor, cardindex, categoryid FROM public.card "
				+ "WHERE categoryid = :categoryid ORDER BY cardindex, given")
				.bind("categoryid", categoryId)
				.map(new CardMapper())
				.list();
	}
	
	public void update(Handle handle, CardUpdateData cardModel) {
		Update statement = handle.createStatement("UPDATE public.card SET given = :given, wanted = :wanted, cardindex = :cardindex WHERE cardid = :cardid");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("given",  cardModel.getGiven() );
		statement.bind("wanted",  cardModel.getWanted() );
		statement.bind("cardindex",  cardModel.getCardIndex() );
		statement.execute();
	}



}
