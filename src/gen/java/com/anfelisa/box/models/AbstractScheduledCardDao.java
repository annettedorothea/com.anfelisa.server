package com.anfelisa.box.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractScheduledCardDao {
	
	public void insert(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createUpdate("INSERT INTO \"scheduledcard\" (scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate) VALUES (:scheduledcardid, :cardid, :boxid, :createddate, :ef, :interval, :n, :count, :scheduleddate, :lastquality, :quality, :scoreddate)");
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId() );
		statement.bind("cardid",  scheduledCardModel.getCardId() );
		statement.bind("boxid",  scheduledCardModel.getBoxId() );
		statement.bind("createddate",  scheduledCardModel.getCreatedDate() );
		statement.bind("ef",  scheduledCardModel.getEf() );
		statement.bind("interval",  scheduledCardModel.getInterval() );
		statement.bind("n",  scheduledCardModel.getN() );
		statement.bind("count",  scheduledCardModel.getCount() );
		statement.bind("scheduleddate",  scheduledCardModel.getScheduledDate() );
		statement.bind("lastquality",  scheduledCardModel.getLastQuality() );
		statement.bind("quality",  scheduledCardModel.getQuality() );
		statement.bind("scoreddate",  scheduledCardModel.getScoredDate() );
		statement.execute();
	}
	
	
	public void updateByScheduledCardId(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createUpdate("UPDATE \"scheduledcard\" SET scheduledcardid = :scheduledcardid, cardid = :cardid, boxid = :boxid, createddate = :createddate, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, lastquality = :lastquality, quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId() );
		statement.bind("cardid",  scheduledCardModel.getCardId() );
		statement.bind("boxid",  scheduledCardModel.getBoxId() );
		statement.bind("createddate",  scheduledCardModel.getCreatedDate() );
		statement.bind("ef",  scheduledCardModel.getEf() );
		statement.bind("interval",  scheduledCardModel.getInterval() );
		statement.bind("n",  scheduledCardModel.getN() );
		statement.bind("count",  scheduledCardModel.getCount() );
		statement.bind("scheduleddate",  scheduledCardModel.getScheduledDate() );
		statement.bind("lastquality",  scheduledCardModel.getLastQuality() );
		statement.bind("quality",  scheduledCardModel.getQuality() );
		statement.bind("scoreddate",  scheduledCardModel.getScoredDate() );
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId()  );
		statement.execute();
	}

	public void deleteByScheduledCardId(Handle handle, String scheduledCardId) {
		Update statement = handle.createUpdate("DELETE FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(Handle handle, String scheduledCardId) {
		Optional<IScheduledCardModel> optional = handle.createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IScheduledCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\"")
			.map(new ScheduledCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"scheduledcard\" CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
