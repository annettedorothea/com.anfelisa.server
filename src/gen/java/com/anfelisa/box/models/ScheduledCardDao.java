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
	
	public Integer insert(Handle handle, IScheduledCardModel scheduledCardModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.scheduledcard (cardid, ef, interval, n, count, scheduleddate, boxid, lastquality, timestamp, removed) VALUES (:cardid, :ef, :interval, :n, :count, :scheduleddate, :boxid, :lastquality, :timestamp, :removed) RETURNING scheduledcardid");
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
		Map<String, Object> first = statement.first();
		return (Integer) first.get("scheduledcardid");
	}
	
	
	public void updateByScheduledCardId(Handle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.createStatement("UPDATE public.scheduledcard SET cardid = :cardid, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, boxid = :boxid, lastquality = :lastquality, timestamp = :timestamp, removed = :removed WHERE scheduledcardid = :scheduledcardid");
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

	public void deleteByScheduledCardId(Handle handle, Integer scheduledCardId) {
		Update statement = handle.createStatement("DELETE FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(Handle handle, Integer scheduledCardId) {
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
		statement = handle.createStatement("ALTER SEQUENCE public.scheduledcard_scheduledCardId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
