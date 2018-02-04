package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class ScoredCardDao {
	
	public Integer insert(Handle handle, IScoredCardModel scoredCardModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.scoredcard (cardid, scheduleddateofscored, boxid, quality, timestamp, points, scheduledcardid) VALUES (:cardid, :scheduleddateofscored, :boxid, :quality, :timestamp, :points, :scheduledcardid) RETURNING scoredcardid");
		statement.bind("cardid",  scoredCardModel.getCardId() );
		statement.bind("scheduleddateofscored",  scoredCardModel.getScheduledDateOfScored() );
		statement.bind("boxid",  scoredCardModel.getBoxId() );
		statement.bind("quality",  scoredCardModel.getQuality() );
		statement.bind("timestamp",  scoredCardModel.getTimestamp() );
		statement.bind("points",  scoredCardModel.getPoints() );
		statement.bind("scheduledcardid",  scoredCardModel.getScheduledCardId() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("scoredcardid");
	}
	
	
	public void updateByScoredCardId(Handle handle, IScoredCardModel scoredCardModel) {
		Update statement = handle.createStatement("UPDATE public.scoredcard SET cardid = :cardid, scheduleddateofscored = :scheduleddateofscored, boxid = :boxid, quality = :quality, timestamp = :timestamp, points = :points, scheduledcardid = :scheduledcardid WHERE scoredcardid = :scoredcardid");
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

	public void deleteByScoredCardId(Handle handle, Integer scoredCardId) {
		Update statement = handle.createStatement("DELETE FROM public.scoredcard WHERE scoredcardid = :scoredcardid");
		statement.bind("scoredcardid", scoredCardId);
		statement.execute();
	}

	public IScoredCardModel selectByScoredCardId(Handle handle, Integer scoredCardId) {
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
		statement = handle.createStatement("ALTER SEQUENCE public.scoredcard_scoredCardId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
