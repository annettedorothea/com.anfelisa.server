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
public class AbstractBoxDao {
	
	public void insert(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createUpdate("INSERT INTO \"box\" (boxid, userid, categoryid, maxinterval, maxcardsperday) VALUES (:boxid, :userid, :categoryid, :maxinterval, :maxcardsperday)");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.execute();
	}
	
	
	public void updateByBoxId(Handle handle, IBoxModel boxModel) {
		Update statement = handle.createUpdate("UPDATE \"box\" SET boxid = :boxid, userid = :userid, categoryid = :categoryid, maxinterval = :maxinterval, maxcardsperday = :maxcardsperday WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(Handle handle, String boxId) {
		Update statement = handle.createUpdate("DELETE FROM \"box\" WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(Handle handle, String boxId) {
		Optional<IBoxModel> optional = handle.createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday FROM \"box\" WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IBoxModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday FROM \"box\"")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"box\" CASCADE");
		statement.execute();
	}

}




/******* S.D.G. *******/



