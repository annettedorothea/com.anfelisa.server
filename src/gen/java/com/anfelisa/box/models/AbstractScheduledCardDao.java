/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractScheduledCardDao {
	
	public void insert(PersistenceHandle handle, IScheduledCardModel scheduledCardModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"scheduledcard\" (scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate) VALUES (:scheduledcardid, :cardid, :boxid, :createddate, :ef, :interval, :n, :count, :scheduleddate, :lastquality, :quality, :scoreddate)");
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
		Update statement = handle.getHandle().createUpdate("UPDATE \"scheduledcard\" SET scheduledcardid = :scheduledcardid, cardid = :cardid, boxid = :boxid, createddate = :createddate, ef = :ef, interval = :interval, n = :n, count = :count, scheduleddate = :scheduleddate, lastquality = :lastquality, quality = :quality, scoreddate = :scoreddate WHERE scheduledcardid = :scheduledcardid");
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
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IScheduledCardModel selectByScheduledCardId(PersistenceHandle handle, String scheduledCardId) {
		Optional<IScheduledCardModel> optional = handle.getHandle().createQuery("SELECT scheduledcardid, cardid, boxid, createddate, ef, interval, n, count, scheduleddate, lastquality, quality, scoreddate FROM \"scheduledcard\" WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ScheduledCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IScheduledCardModel> selectAll(PersistenceHandle handle) {
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



