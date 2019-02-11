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

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractReinforceCardDao {
	
	public void insert(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createUpdate("INSERT INTO \"reinforcecard\" (reinforcecardid, scheduledcardid, boxid, changedate) VALUES (:reinforcecardid, :scheduledcardid, :boxid, :changedate)");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.execute();
	}
	
	
	public void updateByReinforceCardId(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createUpdate("UPDATE \"reinforcecard\" SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId()  );
		statement.execute();
	}

	public void deleteByReinforceCardId(Handle handle, String reinforceCardId) {
		Update statement = handle.createUpdate("DELETE FROM \"reinforcecard\" WHERE reinforcecardid = :reinforcecardid");
		statement.bind("reinforcecardid", reinforceCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByReinforceCardId(Handle handle, String reinforceCardId) {
		Optional<IReinforceCardModel> optional = handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM \"reinforcecard\" WHERE reinforcecardid = :reinforcecardid")
			.bind("reinforcecardid", reinforceCardId)
			.map(new ReinforceCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	public void updateByScheduledCardId(Handle handle, IReinforceCardModel reinforceCardModel) {
		Update statement = handle.createUpdate("UPDATE \"reinforcecard\" SET reinforcecardid = :reinforcecardid, scheduledcardid = :scheduledcardid, boxid = :boxid, changedate = :changedate WHERE scheduledcardid = :scheduledcardid");
		statement.bind("reinforcecardid",  reinforceCardModel.getReinforceCardId() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId() );
		statement.bind("boxid",  reinforceCardModel.getBoxId() );
		statement.bind("changedate",  reinforceCardModel.getChangeDate() );
		statement.bind("scheduledcardid",  reinforceCardModel.getScheduledCardId()  );
		statement.execute();
	}

	public void deleteByScheduledCardId(Handle handle, String scheduledCardId) {
		Update statement = handle.createUpdate("DELETE FROM \"reinforcecard\" WHERE scheduledcardid = :scheduledcardid");
		statement.bind("scheduledcardid", scheduledCardId);
		statement.execute();
	}

	public IReinforceCardModel selectByScheduledCardId(Handle handle, String scheduledCardId) {
		Optional<IReinforceCardModel> optional = handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM \"reinforcecard\" WHERE scheduledcardid = :scheduledcardid")
			.bind("scheduledcardid", scheduledCardId)
			.map(new ReinforceCardMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IReinforceCardModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT reinforcecardid, scheduledcardid, boxid, changedate FROM \"reinforcecard\"")
			.map(new ReinforceCardMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"reinforcecard\" CASCADE");
		statement.execute();
	}

}




/******* S.D.G. *******/



