package com.anfelisa.card.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractCardDao {
	
	public void insert(Handle handle, ICardModel cardModel) {
		Update statement = handle.createUpdate("INSERT INTO \"card\" (cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid) VALUES (:cardid, :given, :wanted, :image, :cardauthor, :cardindex, :categoryid, :rootcategoryid)");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("given",  cardModel.getGiven() );
		statement.bind("wanted",  cardModel.getWanted() );
		statement.bind("image",  cardModel.getImage() );
		statement.bind("cardauthor",  cardModel.getCardAuthor() );
		statement.bind("cardindex",  cardModel.getCardIndex() );
		statement.bind("categoryid",  cardModel.getCategoryId() );
		statement.bind("rootcategoryid",  cardModel.getRootCategoryId() );
		statement.execute();
	}
	
	
	public void updateByCardId(Handle handle, ICardModel cardModel) {
		Update statement = handle.createUpdate("UPDATE \"card\" SET cardid = :cardid, given = :given, wanted = :wanted, image = :image, cardauthor = :cardauthor, cardindex = :cardindex, categoryid = :categoryid, rootcategoryid = :rootcategoryid WHERE cardid = :cardid");
		statement.bind("cardid",  cardModel.getCardId() );
		statement.bind("given",  cardModel.getGiven() );
		statement.bind("wanted",  cardModel.getWanted() );
		statement.bind("image",  cardModel.getImage() );
		statement.bind("cardauthor",  cardModel.getCardAuthor() );
		statement.bind("cardindex",  cardModel.getCardIndex() );
		statement.bind("categoryid",  cardModel.getCategoryId() );
		statement.bind("rootcategoryid",  cardModel.getRootCategoryId() );
		statement.bind("cardid",  cardModel.getCardId()  );
		statement.execute();
	}

	public void deleteByCardId(Handle handle, String cardId) {
		Update statement = handle.createUpdate("DELETE FROM \"card\" WHERE cardid = :cardid");
		statement.bind("cardid", cardId);
		statement.execute();
	}

	public ICardModel selectByCardId(Handle handle, String cardId) {
		Optional<ICardModel> optional = handle.createQuery("SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid FROM \"card\" WHERE cardid = :cardid")
			.bind("cardid", cardId)
			.map(new CardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<ICardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid FROM \"card\"")
			.map(new CardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"card\" CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
