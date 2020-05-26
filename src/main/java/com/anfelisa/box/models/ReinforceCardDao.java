package com.anfelisa.box.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.box.data.IScoreCardData;

import de.acegen.PersistenceHandle;

public class ReinforceCardDao extends AbstractReinforceCardDao {
	public void insert(PersistenceHandle handle, IScoreCardData scoreCardData) {
		Update statement = handle.getHandle().createUpdate(
				"INSERT INTO public.reinforcecard (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid", scoreCardData.getReinforceCardId());
		statement.bind("scheduledcardid", scoreCardData.getScoredCardScheduledCardId());
		statement.bind("boxid", scoreCardData.getBoxId());
		statement.bind("changedate", scoreCardData.getReinforceCardCreatedDate());
		statement.execute();
	}

	public INextCardViewModel selectFirstReinforceCard(PersistenceHandle handle, String boxId) {
		Optional<INextCardViewModel> optional = handle.getHandle().createQuery(
				"SELECT "
						+ "null as scheduledcardid, "
						+ "r.reinforcecardid, "
						+ "c.cardid, "
						+ "sc.scheduleddate, "
						+ "r.changedate, "
						+ "sc.quality as lastQuality, "
						+ "c.given, "
						+ "c.wanted, "
						+ "c.image, "
						+ "c.categoryid, "
						+ "c.rootcategoryid, "
						+ "sc.count, "
						+ "sc.scoreddate "
						+ "FROM public.reinforcecard r "
						+ "inner join public.scheduledcard sc on r.scheduledcardid = sc.scheduledcardid "
						+ "inner join public.card c on sc.cardid = c.cardid "
						+ "inner join public.category ct on c.categoryid = ct.categoryid "
						+ "where sc.boxid = :boxid "
						+ "order by r.changedate, ct.categoryindex, c.cardindex limit 1")
				.bind("boxid", boxId).map(new NextCardViewMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateChangeDate(PersistenceHandle handle, String reinforceCardId, LocalDateTime changeDate) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.reinforcecard SET changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.bind("changedate", changeDate);
		statement.execute();
	}

	public List<IReinforceCardModel> selectOutdatedReinforceCards(PersistenceHandle handle, String boxId, LocalDateTime today) {
		return handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM reinforcecard "
				+ "WHERE boxid = :boxId AND changedate < :today")
				.bind("boxId", boxId)
				.bind("today", today)
				.map(new ReinforceCardMapper())
				.list();
	}

	public List<IReinforceCardModel> selectAllOfBox(PersistenceHandle handle, String boxId) {
		return handle.getHandle().createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM reinforcecard "
				+ "WHERE boxid = :boxId")
				.bind("boxId", boxId)
				.map(new ReinforceCardMapper())
				.list();
	}
	
	public List<IReinforceCardModel> selectAllOfCard(PersistenceHandle handle, String cardId) {
		return handle.getHandle().createQuery("SELECT r.reinforcecardid, r.scheduledcardid, r.boxid, r.changedate "
				+ "FROM reinforcecard r "
				+ "INNER JOIN scheduledcard s on s.scheduledcardid = r.scheduledcardid "
				+ "WHERE s.cardid = :cardid")
				.bind("cardid", cardId)
				.map(new ReinforceCardMapper())
				.list();
	}
	
	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"reinforcecard\" WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

}

/* S.D.G. */
