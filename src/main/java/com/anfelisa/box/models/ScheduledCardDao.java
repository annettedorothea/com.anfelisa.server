package com.anfelisa.box.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import de.acegen.PersistenceHandle;

public class ScheduledCardDao extends AbstractScheduledCardDao {
	public NextCardViewModel selectFirstScheduledCard(PersistenceHandle handle, String boxId, LocalDateTime today) {
		LocalDateTime endOfDay = today.plusDays(1);
		Optional<NextCardViewModel> optional = handle.getHandle().createQuery(
				"SELECT "
						+ "sc.scheduledcardid, "
						+ "null as reinforcecardid, "
						+ "c.cardid, "
						+ "sc.scheduleddate, "
						+ "sc.lastquality, "
						+ "c.given, "
						+ "c.wanted, "
						+ "c.categoryid, "
						+ "ct.categoryname, "
						+ "c.rootcategoryid, "
						+ "sc.count, "
						+ "(select subscc.scoreddate from scheduledcard subscc where subscc.cardid = sc.cardid and scoreddate is not null order by scoreddate desc limit 1) as scoreddate "
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

	public Integer selectCardCountOfDay(PersistenceHandle handle, String boxId, LocalDateTime startOfToday, LocalDateTime endOfToday) {
		Optional<Integer> optional = handle.getHandle().createQuery("SELECT count(sc.scheduledcardid) FROM public.scheduledcard sc "
				+ "inner join public.card c on c.cardid = sc.cardid "
				+ "inner join public.category ct on c.categoryid = ct.categoryid "
				+ "WHERE sc.boxid = :boxId and sc.scheduleddate >= :startoftoday and sc.scheduleddate < :endoftoday and quality is null")
				.bind("boxId", boxId).bind("startoftoday", startOfToday).bind("endoftoday", endOfToday)
				.mapTo(Integer.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void scheduleScheduledCard(PersistenceHandle handle, String scheduledCardId, LocalDateTime scheduleddDate) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.scheduledcard SET scheduleddate = :scheduleddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduleddate", scheduleddDate);
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public void score(PersistenceHandle handle, ScoreCardModel scoreCardData) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.scheduledcard SET quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scoreCardData.getScheduledCardId());
		statement.bind("quality", scoreCardData.getScoredCardQuality());
		statement.bind("scoreddate", scoreCardData.getScoredCardScoredDate());
		statement.execute();
	}

	public void scheduleNext(PersistenceHandle handle, ScoreCardModel scoreCardData) {
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

	public List<ScheduledCardModel> selectAllCardsOfBox(PersistenceHandle handle, String boxId) {
		return handle.getHandle().createQuery(
				"SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard "
						+ "where boxid = :boxid")
				.bind("boxid", boxId).map(new ScheduledCardMapper()).list();
	}

	public void postponeScheduledCards(PersistenceHandle handle, PostponeCardsModel data, LocalDateTime today) {
		Update statement = handle.getHandle()
				.createUpdate("UPDATE public.scheduledcard SET scheduleddate = scheduleddate + "
						+ "(select abs((select min(scheduleddate) from scheduledcard where boxid = :boxId and quality is null) :: date - :today :: date)) * INTERVAL '1 day' "
						+ "WHERE boxid = :boxId and quality is null");
		statement.bind("boxId", data.getBoxId());
		statement.bind("today", today);
		statement.execute();
	}

	public void sortOutCard(PersistenceHandle handle, String scheduledCardId ) {
		Update statement = handle.getHandle()
				.createUpdate("UPDATE public.scheduledcard SET scheduleddate = null "
						+ "WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}
	
	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM scheduledcard WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public ScheduledCardModel selectUnscoredByCardIdAndBoxId(PersistenceHandle handle, String cardId, String boxId) {
		Optional<ScheduledCardModel> optional = handle.getHandle().createQuery("SELECT "
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
