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

import com.anfelisa.ace.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractBoxDao {
	
	public void insert(PersistenceHandle handle, IBoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"box\" (boxid, userid, categoryid, maxinterval, maxcardsperday) VALUES (:boxid, :userid, :categoryid, :maxinterval, :maxcardsperday)");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.execute();
	}
	
	
	public void updateByBoxId(PersistenceHandle handle, IBoxModel boxModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"box\" SET boxid = :boxid, userid = :userid, categoryid = :categoryid, maxinterval = :maxinterval, maxcardsperday = :maxcardsperday WHERE boxid = :boxid");
		statement.bind("boxid",  boxModel.getBoxId() );
		statement.bind("userid",  boxModel.getUserId() );
		statement.bind("categoryid",  boxModel.getCategoryId() );
		statement.bind("maxinterval",  boxModel.getMaxInterval() );
		statement.bind("maxcardsperday",  boxModel.getMaxCardsPerDay() );
		statement.bind("boxid",  boxModel.getBoxId()  );
		statement.execute();
	}

	public void deleteByBoxId(PersistenceHandle handle, String boxId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"box\" WHERE boxid = :boxid");
		statement.bind("boxid", boxId);
		statement.execute();
	}

	public IBoxModel selectByBoxId(PersistenceHandle handle, String boxId) {
		Optional<IBoxModel> optional = handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday FROM \"box\" WHERE boxid = :boxid")
			.bind("boxid", boxId)
			.map(new BoxMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IBoxModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT boxid, userid, categoryid, maxinterval, maxcardsperday FROM \"box\"")
			.map(new BoxMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"box\" CASCADE");
		statement.execute();
	}

}




/******* S.D.G. *******/



