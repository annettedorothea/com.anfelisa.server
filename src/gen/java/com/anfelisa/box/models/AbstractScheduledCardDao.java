/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import de.acegen.AbstractDao;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractScheduledCardDao extends AbstractDao {
	
	public void insert(PersistenceHandle handle, com.anfelisa.box.models.ScheduledCardModel scheduledCardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"scheduledcard\" (scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate) VALUES (:scheduledcardid, :cardid, :boxid, :createddate, :ef, :interval, :n, :count, :scheduleddate, :lastquality, :quality, :scoreddate)");
		statement.bind("scheduledcardid", scheduledCardModel.getScheduledCardId());
		statement.bind("cardid", scheduledCardModel.getCardId());
		statement.bind("boxid", scheduledCardModel.getBoxId());
		statement.bind("createddate", scheduledCardModel.getCreatedDate());
		statement.bind("ef", scheduledCardModel.getEf());
		statement.bind("interval", scheduledCardModel.getInterval());
		statement.bind("n", scheduledCardModel.getN());
		statement.bind("count", scheduledCardModel.getCount());
		statement.bind("scheduleddate", scheduledCardModel.getScheduledDate());
		statement.bind("lastquality", scheduledCardModel.getLastQuality());
		statement.bind("quality", scheduledCardModel.getQuality());
		statement.bind("scoreddate", scheduledCardModel.getScoredDate());
		statement.execute();
	}
	
	
	public void updateByScheduledCardId(PersistenceHandle handle, com.anfelisa.box.models.ScheduledCardModel scheduledCardModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"scheduledcard\" SET scheduledcardid = :scheduledcardid, cardid = :cardid, boxid = :boxid, createddate = :createddate, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, lastquality = :lastquality, quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardModel.getScheduledCardId());
		statement.bind("cardid", scheduledCardModel.getCardId());
		statement.bind("boxid", scheduledCardModel.getBoxId());
		statement.bind("createddate", scheduledCardModel.getCreatedDate());
		statement.bind("ef", scheduledCardModel.getEf());
		statement.bind("interval", scheduledCardModel.getInterval());
		statement.bind("n", scheduledCardModel.getN());
		statement.bind("count", scheduledCardModel.getCount());
		statement.bind("scheduleddate", scheduledCardModel.getScheduledDate());
		statement.bind("lastquality", scheduledCardModel.getLastQuality());
		statement.bind("quality", scheduledCardModel.getQuality());
		statement.bind("scoreddate", scheduledCardModel.getScoredDate());
		statement.execute();
	}

	public void deleteByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public com.anfelisa.box.models.ScheduledCardModel selectByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Optional<com.anfelisa.box.models.ScheduledCardModel> optional = handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public com.anfelisa.box.models.ScheduledCardModel selectByPrimaryKey(PersistenceHandle handle, String scheduledCardId) {
		Optional<com.anfelisa.box.models.ScheduledCardModel> optional = handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"scheduledcard\"";
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

	public List<com.anfelisa.box.models.ScheduledCardModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\"")
			.map(new ScheduledCardMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"scheduledcard\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



