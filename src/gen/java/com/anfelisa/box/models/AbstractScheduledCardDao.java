/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractScheduledCardDao {
	
	public void insert(PersistenceHandle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO public.scheduledcard (scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate) VALUES (:scheduledcardid, :cardid, :boxid, :createddate, :ef, :interval, :n, :count, :scheduleddate, :lastquality, :quality, :scoreddate)");
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
	
	
	public void updateByScheduledCardId(PersistenceHandle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE public.scheduledcard SET scheduledcardid = :scheduledcardid, cardid = :cardid, boxid = :boxid, createddate = :createddate, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, lastquality = :lastquality, quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
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

	public void deleteByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Optional<IScheduledCardModel> optional = handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IScheduledCardModel selectByPrimaryKey(PersistenceHandle handle, String scheduledCardId) {
		Optional<IScheduledCardModel> optional = handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM public.scheduledcard";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<IScheduledCardModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM public.scheduledcard")
			.map(new ScheduledCardMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE public.scheduledcard CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



