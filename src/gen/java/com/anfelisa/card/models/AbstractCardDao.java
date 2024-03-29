/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@SuppressWarnings("all")
public class AbstractCardDao {
	
	public void insert(PersistenceHandle handle, com.anfelisa.card.models.CardModel cardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"card\" (cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, priority) VALUES (:cardid, :given, :wanted, :cardauthor, :cardindex, :categoryid, :rootcategoryid, :priority)");
		statement.bind("cardid", cardModel.getCardId());
		statement.bind("given", cardModel.getGiven());
		statement.bind("wanted", cardModel.getWanted());
		statement.bind("cardauthor", cardModel.getCardAuthor());
		statement.bind("cardindex", cardModel.getCardIndex());
		statement.bind("categoryid", cardModel.getCategoryId());
		statement.bind("rootcategoryid", cardModel.getRootCategoryId());
		statement.bind("priority", cardModel.getPriority());
		statement.execute();
	}
	
	
	public void updateByCardId(PersistenceHandle handle, com.anfelisa.card.models.CardModel cardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"card\" SET cardid = :cardid, given = :given, wanted = :wanted, cardauthor = :cardauthor, cardindex = :cardindex, categoryid = :categoryid, rootcategoryid = :rootcategoryid, priority = :priority WHERE cardid = :cardid");
		statement.bind("cardid", cardModel.getCardId());
		statement.bind("given", cardModel.getGiven());
		statement.bind("wanted", cardModel.getWanted());
		statement.bind("cardauthor", cardModel.getCardAuthor());
		statement.bind("cardindex", cardModel.getCardIndex());
		statement.bind("categoryid", cardModel.getCategoryId());
		statement.bind("rootcategoryid", cardModel.getRootCategoryId());
		statement.bind("priority", cardModel.getPriority());
		statement.execute();
	}

	public void deleteByCardId(PersistenceHandle handle, String cardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"card\" WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public com.anfelisa.card.models.CardModel selectByCardId(PersistenceHandle handle, String cardId) {
		Optional<com.anfelisa.card.models.CardModel> optional = handle.getHandle().createQuery("SELECT cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM \"card\" WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public com.anfelisa.card.models.CardModel selectByPrimaryKey(PersistenceHandle handle, String cardId) {
		Optional<com.anfelisa.card.models.CardModel> optional = handle.getHandle().createQuery("SELECT cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM \"card\" WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"card\"";
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

	public List<com.anfelisa.card.models.CardModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT cardid, given, wanted, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM \"card\"")
			.map(new CardMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"card\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



