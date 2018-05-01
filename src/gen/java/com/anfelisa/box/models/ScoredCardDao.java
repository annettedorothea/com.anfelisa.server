package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ScoredCardDao {
	
	public void insert(Handle handle, IScoredCardModel scoredCardModel) {
		Update statement = handle.createStatement("INSERT INTO public.scoredcard (scoredcardid, cardid, scheduleddateofscored, boxid, quality, timestamp, points, scheduledcardid) VALUES (:scoredcardid, :cardid, :scheduleddateofscored, :boxid, :quality, :timestamp, :points, :scheduledcardid)");
		statement.bind("scoredcardid",  scoredCardModel.getScoredCardId() );
		statement.bind("cardid",  scoredCardModel.getCardId() );
		statement.bind("scheduleddateofscored",  scoredCardModel.getScheduledDateOfScored() );
		statement.bind("boxid",  scoredCardModel.getBoxId() );
		statement.bind("quality",  scoredCardModel.getQuality() );
		statement.bind("timestamp",  scoredCardModel.getTimestamp() );
		statement.bind("points",  scoredCardModel.getPoints() );
		statement.bind("scheduledcardid",  scoredCardModel.getScheduledCardId() );
		statement.execute();
	}
	
	
	public void updateByScoredCardId(Handle handle, IScoredCardModel scoredCardModel) {
		Update statement = handle.createStatement("UPDATE public.scoredcard SET scoredcardid = :scoredcardid, cardid = :cardid, scheduleddateofscored = :scheduleddateofscored, boxid = :boxid, quality = :quality, timestamp = :timestamp, points = :points, scheduledcardid = :scheduledcardid WHERE scoredcardid = :scoredcardid");
		statement.bind("scoredcardid",  scoredCardModel.getScoredCardId() );
		statement.bind("cardid",  scoredCardModel.getCardId() );
		statement.bind("scheduleddateofscored",  scoredCardModel.getScheduledDateOfScored() );
		statement.bind("boxid",  scoredCardModel.getBoxId() );
		statement.bind("quality",  scoredCardModel.getQuality() );
		statement.bind("timestamp",  scoredCardModel.getTimestamp() );
		statement.bind("points",  scoredCardModel.getPoints() );
		statement.bind("scheduledcardid",  scoredCardModel.getScheduledCardId() );
		statement.bind("scoredcardid",  scoredCardModel.getScoredCardId()  );
		statement.execute();
	}

	public void deleteByScoredCardId(Handle handle, String scoredCardId) {
		Update statement = handle.createStatement("DELETE FROM public.scoredcard WHERE scoredcardid = :scoredcardid");
		statement.bind("scoredcardid", scoredCardId);
		statement.execute();
	}

	public IScoredCardModel selectByScoredCardId(Handle handle, String scoredCardId) {
		return handle.createQuery("SELECT scoredcardid, cardid, scheduleddateofscored, boxid, quality, timestamp, points, scheduledcardid FROM public.scoredcard WHERE scoredcardid = :scoredcardid")
			.bind("scoredcardid", scoredCardId)
			.map(new ScoredCardMapper())
			.first();
	}
	
	public List<IScoredCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT scoredcardid, cardid, scheduleddateofscored, boxid, quality, timestamp, points, scheduledcardid FROM public.scoredcard")
			.map(new ScoredCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.scoredcard CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
