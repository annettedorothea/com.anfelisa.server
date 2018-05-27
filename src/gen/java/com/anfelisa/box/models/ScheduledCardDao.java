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
public class ScheduledCardDao {
	
	public void insert(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createStatement("INSERT INTO public.scheduledcard (scheduledcardid, cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp, removed) VALUES (:scheduledcardid, :cardid, :ef, :interval, :n, :count, :scheduleddate, :boxid, :lastquality, :timestamp, :removed)");
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId() );
		statement.bind("cardid",  scheduledCardModel.getCardId() );
		statement.bind("ef",  scheduledCardModel.getEf() );
		statement.bind("interval",  scheduledCardModel.getInterval() );
		statement.bind("n",  scheduledCardModel.getN() );
		statement.bind("count",  scheduledCardModel.getCount() );
		statement.bind("scheduleddate",  scheduledCardModel.getScheduledDate() );
		statement.bind("boxid",  scheduledCardModel.getBoxId() );
		statement.bind("lastquality",  scheduledCardModel.getLastQuality() );
		statement.bind("timestamp",  scheduledCardModel.getTimestamp() );
		statement.bind("removed",  scheduledCardModel.getRemoved() );
		statement.execute();
	}
	
	
	public void updateByScheduledCardId(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createStatement("UPDATE public.scheduledcard SET scheduledcardid = :scheduledcardid, cardid = :cardid, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, boxid = :boxid, lastquality = :lastquality, timestamp = :timestamp, removed = :removed WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId() );
		statement.bind("cardid",  scheduledCardModel.getCardId() );
		statement.bind("ef",  scheduledCardModel.getEf() );
		statement.bind("interval",  scheduledCardModel.getInterval() );
		statement.bind("n",  scheduledCardModel.getN() );
		statement.bind("count",  scheduledCardModel.getCount() );
		statement.bind("scheduleddate",  scheduledCardModel.getScheduledDate() );
		statement.bind("boxid",  scheduledCardModel.getBoxId() );
		statement.bind("lastquality",  scheduledCardModel.getLastQuality() );
		statement.bind("timestamp",  scheduledCardModel.getTimestamp() );
		statement.bind("removed",  scheduledCardModel.getRemoved() );
		statement.bind("scheduledcardid",  scheduledCardModel.getScheduledCardId()  );
		statement.execute();
	}

	public void deleteByScheduledCardId(Handle handle, String scheduledCardId) {
		Update statement = handle.createStatement("DELETE FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(Handle handle, String scheduledCardId) {
		return handle.createQuery("SELECT scheduledcardid, cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp, removed FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.first();
	}
	
	public List<IScheduledCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT scheduledcardid, cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp, removed FROM public.scheduledcard")
			.map(new ScheduledCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.scheduledcard CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
