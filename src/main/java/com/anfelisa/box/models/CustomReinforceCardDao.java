package com.anfelisa.box.models;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.box.data.ScoreCardData;

public class CustomReinforceCardDao {

	public void insert(Handle handle, ScoreCardData scoreCardData) {
		Update statement = handle.createStatement(
				"INSERT INTO public.reinforcecard (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid", scoreCardData.getReinforceCardId());
		statement.bind("scheduledcardid", scoreCardData.getScoredCardScheduledCardId());
		statement.bind("boxid", scoreCardData.getBoxId());
		statement.bind("changedate", scoreCardData.getReinforceCardCreatedDate());
		statement.execute();
	}

	public INextReinforceCardModel selectFirstScheduledCard(Handle handle, String boxId) {
		return handle.createQuery(
				"SELECT r.reinforcecardid, r.changedate, sc.quality as lastQuality, c.given, c.wanted, c.image FROM public.reinforcecard r "
						+ "inner join public.scheduledcard sc on r.scheduledcardid = sc.scheduledcardid "
						+ "inner join public.card c on sc.cardid = c.cardid where sc.boxid = :boxid order by r.changedate")
				.bind("boxid", boxId).map(new NextReinforceCardMapper()).first();
	}

	public void updateChangeDate(Handle handle, String reinforceCardId, DateTime changeDate) {
		Update statement = handle.createStatement(
				"UPDATE public.reinforcecard SET changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.bind("changedate", changeDate);
		statement.execute();
	}

}
