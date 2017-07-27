package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class CustomScheduledCardDao {

	public List<IScheduledCardModel> selectTodaysCards(Handle handle, Integer boxId) {
		return handle
				.createQuery(
						"SELECT * FROM anfelisa.scheduledcard WHERE boxid = :boxId AND removed = false AND date_trunc('day', scheduledDate) <= date_trunc('day', now()) ORDER BY timestamp DESC")
				.bind("boxId", boxId).map(new ScheduledCardMapper()).list();
	}

	public IScheduledCardModel selectFirstScheduledCard(Handle handle, Integer boxId) {
		return handle
				.createQuery(
						"SELECT * FROM anfelisa.scheduledcard WHERE boxid = :boxId AND removed = false order by scheduleddate limit 1")
				.bind("boxId", boxId).map(new ScheduledCardMapper()).first();
	}

	public List<IScheduledCardModel> selectTomorrowsCards(Handle handle, Integer boxId) {
		return handle
				.createQuery(
						"SELECT * FROM anfelisa.scheduledcard WHERE boxid = :boxId AND removed = false AND date_trunc('day', scheduledDate) <= date_trunc('day', TIMESTAMP 'tomorrow') AND date_trunc('day', scheduledDate) > date_trunc('day', now())")
				.bind("boxId", boxId).map(new ScheduledCardMapper()).list();
	}

	public List<IScheduledCardModel> selectAllCards(Handle handle, Integer boxId) {
		return handle.createQuery("SELECT * FROM anfelisa.scheduledcard WHERE boxid = :boxId").bind("boxId", boxId)
				.map(new ScheduledCardMapper()).list();
	}

	public void removeScheduledCardFromBox(Handle handle, IScheduledCardIdModel scheduledCardIdModel) {
		Update statement = handle.createStatement(
				"UPDATE anfelisa.scheduledcard SET removed = true WHERE scheduledCardId = :scheduledCardId");
		statement.bind("scheduledCardId", scheduledCardIdModel.getScheduledCardId());
		statement.execute();
	}

	public List<IScheduledCardModel> selectReinforceCards(Handle handle, Integer boxId) {
		return handle
				.createQuery(
						"SELECT * FROM anfelisa.scheduledcard WHERE boxid = :boxId AND removed = false AND lastquality < 4 AND date_trunc('day', timestamp) >= date_trunc('day', now()) ORDER BY timestamp ASC")
				.bind("boxId", boxId).map(new ScheduledCardMapper()).list();
	}

	public void recalculateScheduledCards(Handle handle, Integer boxId, Integer daysBehind) {
		Update statement = handle
				.createStatement("UPDATE anfelisa.scheduledcard SET scheduleddate = scheduleddate + INTERVAL '"
						+ daysBehind + " days' WHERE boxid = :boxId");
		statement.bind("boxId", boxId);
		statement.execute();
	}

}
