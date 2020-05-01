package com.anfelisa.box.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;
import org.joda.time.DateTime;

import com.anfelisa.box.data.IScoreCardData;

import de.acegen.PersistenceHandle;

public class ScheduledCardDao extends AbstractScheduledCardDao {
	public INextCardViewModel selectFirstScheduledCard(PersistenceHandle handle, String boxId, DateTime today) {
		DateTime endOfDay = today.plusDays(1);
		Optional<INextCardViewModel> optional = handle.getHandle().createQuery(
				"SELECT "
						+ "sc.scheduledcardid, "
						+ "null as reinforcecardid, "
						+ "c.cardid, "
						+ "sc.scheduleddate, "
						+ "sc.lastquality, "
						+ "c.given, "
						+ "c.wanted, "
						+ "c.image, "
						+ "c.categoryid, "
						+ "c.rootcategoryid, "
						+ "sc.count, "
						+ "sc.scoreddate "
						+ "FROM public.scheduledcard sc "
						+ "inner join public.card c on c.cardid = sc.cardid "
						+ "inner join public.category ct on c.categoryid = ct.categoryid "
						+ "WHERE sc.boxid = :boxId "
						+ "and quality is null "
						+ "and sc.scheduleddate <= :endofday "
						+ "order by sc.scheduleddate, ct.categoryindex, c.cardindex limit 1")
				.bind("boxId", boxId)
				.bind("endofday", endOfDay)
				.map(new NextCardViewMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public Integer selectCardCountOfDay(PersistenceHandle handle, String boxId, DateTime startOfToday, DateTime endOfToday) {
		Optional<Integer> optional = handle.getHandle().createQuery("SELECT count(sc.scheduledcardid) FROM public.scheduledcard sc "
				+ "inner join public.card c on c.cardid = sc.cardid "
				+ "inner join public.category ct on c.categoryid = ct.categoryid "
				+ "WHERE sc.boxid = :boxId and sc.scheduleddate >= :startoftoday and sc.scheduleddate < :endoftoday and quality is null")
				.bind("boxId", boxId).bind("startoftoday", startOfToday).bind("endoftoday", endOfToday)
				.mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void scheduleScheduledCard(PersistenceHandle handle, String scheduledCardId, DateTime scheduleddDate) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.scheduledcard SET scheduleddate = :scheduleddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduleddate", scheduleddDate);
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public void score(PersistenceHandle handle, IScoreCardData scoreCardData) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.scheduledcard SET quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scoreCardData.getScoredCardScheduledCardId());
		statement.bind("quality", scoreCardData.getScoredCardQuality());
		statement.bind("scoreddate", scoreCardData.getScoredCardScoredDate());
		statement.execute();
	}

	public void scheduleNext(PersistenceHandle handle, IScoreCardData scoreCardData) {
		Update statement = handle.getHandle().createUpdate(
				"INSERT INTO public.scheduledcard (scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality) VALUES (:scheduledcardid, :cardid, :boxid, :createddate, :ef, :interval, :n, :count, :scheduleddate, :lastquality)");
		statement.bind("scheduledcardid", scoreCardData.getNextScheduledCardScheduledCardId());
		statement.bind("cardid", scoreCardData.getCardId());
		statement.bind("boxid", scoreCardData.getBoxId());
		statement.bind("createddate", scoreCardData.getNextScheduledCardCreatedDate());
		statement.bind("ef", scoreCardData.getNextScheduledCardEf());
		statement.bind("interval", scoreCardData.getNextScheduledCardInterval());
		statement.bind("n", scoreCardData.getNextScheduledCardN());
		statement.bind("count", scoreCardData.getNextScheduledCardCount());
		statement.bind("scheduleddate", scoreCardData.getNextScheduledCardScheduledDate());
		statement.bind("lastquality", scoreCardData.getNextScheduledCardLastQuality());
		statement.execute();
	}

	public List<IScheduledCardModel> selectAllCardsOfBox(PersistenceHandle handle, String boxId) {
		return handle.getHandle().createQuery(
				"SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard "
						+ "where boxid = :boxid")
				.bind("boxid", boxId).map(new ScheduledCardMapper()).list();
	}

	public void postponeScheduledCards(PersistenceHandle handle, IPostponeCardsModel data) {
		Update statement = handle.getHandle()
				.createUpdate("UPDATE public.scheduledcard SET scheduleddate = scheduleddate + INTERVAL '"
						+ data.getDays() + " days' WHERE boxid = :boxId and quality is null");
		statement.bind("boxId", data.getBoxId());
		statement.execute();
	}

	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM scheduledcard WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IScheduledCardModel selectUnscoredByCardIdAndBoxId(PersistenceHandle handle, String cardId, String boxId) {
		Optional<IScheduledCardModel> optional = handle.getHandle().createQuery("SELECT "
				+ "scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate "
				+ "FROM scheduledcard "
				+ "WHERE cardid = :cardid "
				+ "AND boxid = :boxid "
				+ "AND quality is NULL")
			.bind("cardid", cardId)
			.bind("boxid", boxId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

}

/* S.D.G. */
