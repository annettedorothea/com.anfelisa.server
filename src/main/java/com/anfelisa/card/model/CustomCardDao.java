package com.anfelisa.card.model;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import com.anfelisa.card.data.CardUpdateData;
import com.anfelisa.card.models.CardMapper;
import com.anfelisa.card.models.ICardModel;

public class CustomCardDao {

	public List<ICardModel> selectAllOfCategory(Handle handle, String categoryId) {
		return handle.createQuery(
				"SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, path FROM public.card "
						+ "WHERE categoryid = :categoryid ORDER BY cardindex, given")
				.bind("categoryid", categoryId).map(new CardMapper()).list();
	}

	public Integer selectMaxIndexInCategory(Handle handle, String categoryId) {
		Optional<Integer> optional = handle.createQuery("SELECT max(cardindex) FROM public.card WHERE categoryid = :categoryid")
				.bind("categoryid", categoryId).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void update(Handle handle, CardUpdateData cardModel) {
		Update statement = handle.createUpdate(
				"UPDATE public.card SET given = :given, wanted = :wanted, image = :image WHERE cardid = :cardid");
		statement.bind("cardid", cardModel.getCardId());
		statement.bind("given", cardModel.getGiven());
		statement.bind("wanted", cardModel.getWanted());
		statement.bind("image", cardModel.getImage());
		statement.execute();
	}

	public List<ICardModel> search(Handle handle, String categoryId, Boolean naturalInputOrder, String given,
			String wanted) {
		String givenSearchString = "%" + given + "%";
		String wantedSearchString = "%" + wanted + "%";
		String orderBy = naturalInputOrder ? "given" : "wanted";
		return handle.createQuery(
				"SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, path FROM public.card "
						+ "where rootcategoryid = (select rootcategoryid from category where category.categoryid = :categoryid) and "
						+ "( length(:given) > 0 and given like :givenSearchString or "
						+ " length(:wanted) > 0 and wanted like :wantedSearchString) " + "order by upper("
						+ orderBy + ") limit 25")
				.bind("categoryid", categoryId)
				.bind("givenSearchString", givenSearchString)
				.bind("wantedSearchString", wantedSearchString)
				.bind("given", given)
				.bind("wanted", wanted)
				.map(new CardMapper()).list();
	}
	
	public void deleteByCategoryId(Handle handle, String categoryId) {
		Update statement = handle.createUpdate("DELETE FROM public.card WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}

	public void shiftCards(Handle handle, Integer cardIndex, String categoryId) {
		Update statement = handle.createUpdate(
				"UPDATE public.card SET cardindex = cardindex-1 WHERE categoryid = :categoryid and cardindex > :cardindex");
		statement.bind("categoryid", categoryId);
		statement.bind("cardindex", cardIndex);
		statement.execute();
	}



}
