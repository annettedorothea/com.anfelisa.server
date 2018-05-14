package com.anfelisa.card.model;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.models.CardMapper;
import com.anfelisa.card.models.ICardModel;

public class CustomCardDao {

	public List<ICardModel> selectAllOfCategory(Handle handle, String categoryId) {
		return handle.createQuery(
				"SELECT cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, path FROM public.card "
						+ "WHERE categoryid = :categoryid ORDER BY cardindex, given")
				.bind("categoryid", categoryId).map(new CardMapper()).list();
	}

	public Integer selectMaxIndexInCategory(Handle handle, String categoryId) {
		return handle.createQuery("SELECT max(cardindex) FROM public.card WHERE categoryid = :categoryid")
				.bind("categoryid", categoryId).mapTo((Integer.class)).first();
	}

	public void update(Handle handle, CardUpdateData cardModel) {
		Update statement = handle.createStatement(
				"UPDATE public.card SET given = :given, wanted = :wanted, cardindex = :cardindex WHERE cardid = :cardid");
		statement.bind("cardid", cardModel.getCardId());
		statement.bind("given", cardModel.getGiven());
		statement.bind("wanted", cardModel.getWanted());
		statement.bind("cardindex", cardModel.getCardIndex());
		statement.execute();
	}

	public List<ICardModel> search(Handle handle, String categoryId, String searchString) {
		searchString = "%" + searchString + "%";
		return handle.createQuery(
				"SELECT cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, path FROM public.card "
						+ "where rootcategoryid = (select rootcategoryid from category where category.categoryid = :categoryid) and given like :searchstring order by given limit 25")
				.bind("categoryid", categoryId).bind("searchstring", searchString).map(new CardMapper()).list();
	}

}
