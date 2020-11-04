/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.card.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractCardDao {
	
	public void insert(PersistenceHandle handle, ICardModel cardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO public.card (cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority) VALUES (:cardid, :given, :wanted, :image, :cardauthor, :cardindex, :categoryid, :rootcategoryid, :priority)");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("given",  cardModel.getGiven() );
		statement.bind("wanted",  cardModel.getWanted() );
		statement.bind("image",  cardModel.getImage() );
		statement.bind("cardauthor",  cardModel.getCardAuthor() );
		statement.bind("cardindex",  cardModel.getCardIndex() );
		statement.bind("categoryid",  cardModel.getCategoryId() );
		statement.bind("rootcategoryid",  cardModel.getRootCategoryId() );
		statement.bind("priority",  cardModel.getPriority() );
		statement.execute();
	}
	
	
	public void updateByCardId(PersistenceHandle handle, ICardModel cardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.card SET cardid = :cardid, given = :given, wanted = :wanted, image = :image, cardauthor = :cardauthor, cardindex = :cardindex, categoryid = :categoryid, rootcategoryid = :rootcategoryid, priority = :priority WHERE cardid = :cardid");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("given",  cardModel.getGiven() );
		statement.bind("wanted",  cardModel.getWanted() );
		statement.bind("image",  cardModel.getImage() );
		statement.bind("cardauthor",  cardModel.getCardAuthor() );
		statement.bind("cardindex",  cardModel.getCardIndex() );
		statement.bind("categoryid",  cardModel.getCategoryId() );
		statement.bind("rootcategoryid",  cardModel.getRootCategoryId() );
		statement.bind("priority",  cardModel.getPriority() );
		statement.bind("cardid",  cardModel.getCardId()  );
		statement.execute();
	}

	public void deleteByCardId(PersistenceHandle handle, String cardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.card WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(PersistenceHandle handle, String cardId) {
		Optional<ICardModel> optional = handle.getHandle().createQuery("SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM public.card WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public ICardModel selectByPrimaryKey(PersistenceHandle handle, String cardId) {
		Optional<ICardModel> optional = handle.getHandle().createQuery("SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM public.card WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM public.card";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<ICardModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM public.card")
			.map(new CardMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE public.card CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



