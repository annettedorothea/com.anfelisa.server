package com.anfelisa.box.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;
import org.joda.time.DateTime;

import com.anfelisa.box.data.IScoreCardData;

public class ReinforceCardDao extends AbstractReinforceCardDao {
	public void insert(Handle handle, IScoreCardData scoreCardData) {
		Update statement = handle.createUpdate(
				"INSERT INTO public.reinforcecard (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid", scoreCardData.getReinforceCardId());
		statement.bind("scheduledcardid", scoreCardData.getScoredCardScheduledCardId());
		statement.bind("boxid", scoreCardData.getBoxId());
		statement.bind("changedate", scoreCardData.getReinforceCardCreatedDate());
		statement.execute();
	}

	public INextCardViewModel selectFirstReinforceCard(Handle handle, String boxId) {
		Optional<INextCardViewModel> optional = handle.createQuery(
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
						+ "where sc.boxid = :boxid "
						+ "order by r.changedate")
				.bind("boxid", boxId).map(new NextCardViewMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateChangeDate(Handle handle, String reinforceCardId, DateTime changeDate) {
		Update statement = handle.createUpdate(
				"UPDATE public.reinforcecard SET changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.bind("changedate", changeDate);
		statement.execute();
	}

	public IReinforceCardModel selectByCardId(Handle handle, String cardId) {
		Optional<IReinforceCardModel> optional = handle.createQuery(
				"SELECT rc.reinforcecardid, rc.scheduledcardid, rc.boxid, rc.changedate FROM public.reinforcecard rc left outer join scheduledcard sc on rc.scheduledcardid = sc.scheduledcardid WHERE cardid = :cardid")
				.bind("cardid", cardId)
				.map(new ReinforceCardMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IReinforceCardModel> selectOutdatedReinforceCards(Handle handle, String boxId, DateTime today) {
		return handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM reinforcecard "
				+ "WHERE boxid = :boxId AND changedate <= :today")
				.bind("boxId", boxId)
				.bind("today", today)
				.map(new ReinforceCardMapper())
				.list();
	}

}

/* S.D.G. */
