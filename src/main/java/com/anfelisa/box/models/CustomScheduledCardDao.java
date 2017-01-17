package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class CustomScheduledCardDao {

	public List<IScheduledCardModel> selectTodaysCards(Handle handle, String schema) {
		return handle
				.createQuery("SELECT * FROM " + schema
						+ ".scheduledcard WHERE date_trunc('day', scheduledDate) <= date_trunc('day', now())")
				.map(new ScheduledCardMapper()).list();
	}
}
