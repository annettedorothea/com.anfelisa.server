package com.anfelisa.box.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;
import org.joda.time.DateTime;

import com.anfelisa.box.data.IPostponeCardsData;
import com.anfelisa.box.data.IScoreCardData;

public class ScheduledCardDao extends AbstractScheduledCardDao {
	public INextCardViewModel selectFirstScheduledCard(Handle handle, String boxId, DateTime today) {
		Optional<INextCardViewModel> optional = handle.createQuery(
				"SELECT sc.scheduledcardid, c.cardid, sc.scheduleddate, sc.boxid, sc.lastquality, c.given, c.wanted, c.image, c.categoryid, c.rootCategoryid as rootCategoryId, sc.count, sc.scoreddate FROM public.scheduledcard sc "
						+ "inner join public.card c on c.cardid = sc.cardid "
						+ "inner join public.category ct on c.categoryid = ct.categoryid "
						+ "WHERE sc.boxid = :boxId and sc.scheduleddate < :today and quality is null order by sc.scheduleddate, ct.categoryindex, c.cardindex limit 1")
				.bind("boxId", boxId).bind("today", today).map(new NextCardViewMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IScheduledCardModel> selectReinforceCards(Handle handle, String boxId, DateTime now) {
		return handle.createQuery(
				"SELECT scheduledcardid, cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp FROM public.scheduledcard WHERE boxid = :boxId AND lastquality < 4 AND date_trunc('day', timestamp) >= date_trunc('day', TIMESTAMP ':now') ORDER BY timestamp ASC")
				.bind("boxId", boxId).bind("now", now.toString()).map(new ScheduledCardMapper()).list();
	}

	public void postponeScheduledCards(Handle handle, IPostponeCardsData postponeCardsData) {
		Update statement = handle
				.createUpdate("UPDATE public.scheduledcard SET scheduleddate = scheduleddate + INTERVAL '"
						+ postponeCardsData.getDays() + " days' WHERE boxid = :boxId and quality is null");
		statement.bind("boxId", postponeCardsData.getBoxId());
		statement.execute();
	}

	public void scheduleScheduledCard(Handle handle, String scheduledCardId, DateTime scheduleddDate) {
		Update statement = handle.createUpdate(
				"UPDATE public.scheduledcard SET scheduleddate = :scheduleddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduleddate", scheduleddDate);
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public String selectNextCardId(Handle handle, String categoryId, String boxId) {
		Optional<String> optional = handle.createQuery(
				"select cardid from (SELECT cardid, cardindex from public.card where categoryid = :categoryid "
						+ "except select c.cardid, c.cardindex FROM public.scheduledcard sc inner join card c on c.cardid = sc.cardid where sc.boxid = :boxid order by cardindex) as cards limit 1")
				.bind("categoryid", categoryId).bind("boxid", boxId).mapTo(String.class).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void score(Handle handle, IScoreCardData scoreCardData) {
		Update statement = handle.createUpdate(
				"UPDATE public.scheduledcard SET quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scoreCardData.getScoredCardScheduledCardId());
		statement.bind("quality", scoreCardData.getScoredCardQuality());
		statement.bind("scoreddate", scoreCardData.getScoredCardScoredDate());
		statement.execute();
	}

	public void scheduleNext(Handle handle, IScoreCardData scoreCardData) {
		Update statement = handle.createUpdate(
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

	public List<IScheduledCardModel> selectAllCardsOfBox(Handle handle, String boxId) {
		return handle.createQuery(
				"SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard "
						+ "where boxid = :boxid and quality is null")
				.bind("boxid", boxId).map(new ScheduledCardMapper()).list();
	}

}


/*       S.D.G.       */
