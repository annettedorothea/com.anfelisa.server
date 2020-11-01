package com.anfelisa.card.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.card.data.ICardUpdateData;

import de.acegen.PersistenceHandle;

public class CardDao extends AbstractCardDao {

	public List<ICardWithInfoModel> selectAllOfCategoryWithBoxInfo(PersistenceHandle handle, String categoryId,
			String boxId) {
		return handle.getHandle().createQuery(
				"SELECT c.cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority, s.scheduleddate as next "
						+ "FROM public.card c "
						+ "left outer join scheduledcard s on c.cardid = s.cardid and s.boxid = :boxid and s.quality is null "
						+ "WHERE categoryid = :categoryid "
						+ "ORDER BY cardindex, given")
				.bind("categoryid", categoryId)
				.bind("boxid", boxId)
				.map(new CardWithInfoMapper()).list();
	}

	public List<ICardWithInfoModel> selectAllNonScheduledOfCategoryWithBoxInfo(PersistenceHandle handle,
			String categoryId,
			String boxId) {
		return handle.getHandle().createQuery(
				"SELECT c.cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority, s.scheduleddate as next "
						+ "FROM public.card c "
						+ "left outer join scheduledcard s on c.cardid = s.cardid and s.boxid = :boxid and s.quality is null "
						+ "WHERE categoryid = :categoryid "
						+ "AND s.scheduleddate is null "
						+ "ORDER BY cardindex, given")
				.bind("categoryid", categoryId)
				.bind("boxid", boxId)
				.map(new CardWithInfoMapper()).list();
	}

	public Integer selectNonScheduledCardCountOfCategory(PersistenceHandle handle, String categoryId,
			String boxId, Integer priority) {
		Optional<Integer> optional = handle.getHandle().createQuery(
				"SELECT count(c.cardid) "
						+ "FROM public.card c "
						+ "left outer join scheduledcard s on c.cardid = s.cardid and s.boxid = :boxid and s.quality is null "
						+ "WHERE categoryid = :categoryid AND (:priority is null OR c.priority = :priority) "
						+ "AND s.scheduleddate is null")
				.bind("categoryid", categoryId)
				.bind("boxid", boxId)
				.bind("priority", priority)
				.mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<ICardModel> selectAll(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery(
				"SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM \"card\" "
						+ "WHERE categoryid = :categoryid ORDER BY cardindex")
				.bind("categoryid", categoryId)
				.map(new CardMapper())
				.list();
	}

	public List<ICardModel> selectAllByRootCategoryId(PersistenceHandle handle, String rootCategoryId) {
		return handle.getHandle().createQuery(
				"SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority FROM \"card\" "
						+ "WHERE rootcategoryid = :rootcategoryid")
				.bind("rootcategoryid", rootCategoryId)
				.map(new CardMapper())
				.list();
	}

	public Integer selectMaxIndexInCategory(PersistenceHandle handle, String categoryId) {
		Optional<Integer> optional = handle.getHandle()
				.createQuery("SELECT max(cardindex) FROM public.card WHERE categoryid = :categoryid")
				.bind("categoryid", categoryId).mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void update(PersistenceHandle handle, ICardUpdateData cardModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.card SET given = :given, wanted = :wanted, image = :image WHERE cardid = :cardid");
		statement.bind("cardid", cardModel.getCardId());
		statement.bind("given", cardModel.getGiven());
		statement.bind("wanted", cardModel.getWanted());
		statement.bind("image", cardModel.getImage());
		statement.execute();
	}

	public void updateIndex(PersistenceHandle handle, ICardModel cardModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.card SET cardindex = :cardindex WHERE cardid = :cardid");
		statement.bind("cardindex", cardModel.getCardIndex());
		statement.bind("cardid", cardModel.getCardId());
		statement.execute();
	}

	public List<ICardWithCategoryNameModel> search(PersistenceHandle handle, String categoryId,
			Boolean naturalInputOrder,
			String given,
			String wanted) {
		String givenSearchString = "%" + given + "%";
		String wantedSearchString = "%" + wanted + "%";
		String orderBy = naturalInputOrder ? "given" : "wanted";
		return handle.getHandle().createQuery(
				"SELECT cardid, given, wanted, image, cardauthor, cardindex, categoryid, rootcategoryid, priority, "
						+ "(select categoryname from category where category.categoryid = cd.categoryid) as categoryname "
						+ "FROM public.card cd where cd.rootcategoryid = (select rootcategoryid from category where category.categoryid = :categoryid) and "
						+ "( length(:given) > 0 and given like :givenSearchString or "
						+ " length(:wanted) > 0 and wanted like :wantedSearchString) " + "order by upper("
						+ orderBy + ") limit 25")
				.bind("categoryid", categoryId)
				.bind("givenSearchString", givenSearchString)
				.bind("wantedSearchString", wantedSearchString)
				.bind("given", given)
				.bind("wanted", wanted)
				.map(new CardWithCategoryNameMapper()).list();
	}

	public void deleteByCategoryId(PersistenceHandle handle, String categoryId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.card WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}

	public void shiftCards(PersistenceHandle handle, Integer cardIndex, String categoryId) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.card SET cardindex = cardindex-1 WHERE categoryid = :categoryid and cardindex > :cardindex");
		statement.bind("categoryid", categoryId);
		statement.bind("cardindex", cardIndex);
		statement.execute();
	}

	public void deleteByRootCategoryId(PersistenceHandle handle, String rootCategoryId) {
		Update statement = handle.getHandle()
				.createUpdate("DELETE FROM public.card WHERE rootcategoryid = :rootcategoryid");
		statement.bind("rootcategoryid", rootCategoryId);
		statement.execute();
	}

	public void updateCardPriority(PersistenceHandle handle, ICardUpdatePriorityModel cardModel) {
		Update statement = handle.getHandle()
				.createUpdate("UPDATE public.card SET priority = :priority WHERE cardid = :cardid");
		statement.bind("priority", cardModel.getPriority());
		statement.bind("cardid", cardModel.getCardId());
		statement.execute();
	}

	public void moveCard(PersistenceHandle handle, ICardModel cardModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.card SET cardindex = :cardindex, categoryid = :categoryid WHERE cardid = :cardid");
		statement.bind("cardindex", cardModel.getCardIndex());
		statement.bind("categoryid", cardModel.getCategoryId());
		statement.bind("cardid", cardModel.getCardId());
		statement.execute();
	}

}

/* S.D.G. */
