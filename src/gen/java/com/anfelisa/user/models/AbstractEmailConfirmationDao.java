/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.2
 *
 */




package com.anfelisa.user.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractEmailConfirmationDao {
	
	public void insert(PersistenceHandle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"emailconfirmation\" (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(PersistenceHandle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"emailconfirmation\" SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.bind("token",  emailConfirmationModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(PersistenceHandle handle, String token) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"emailconfirmation\" WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IEmailConfirmationModel selectByToken(PersistenceHandle handle, String token) {
		Optional<IEmailConfirmationModel> optional = handle.getHandle().createQuery("SELECT token, userid FROM \"emailconfirmation\" WHERE token = :token")
			.bind("token", token)
			.map(new EmailConfirmationMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IEmailConfirmationModel selectByPrimaryKey(PersistenceHandle handle, String token) {
		Optional<IEmailConfirmationModel> optional = handle.getHandle().createQuery("SELECT token, userid FROM \"emailconfirmation\" WHERE token = :token")
			.bind("token", token)
			.map(new EmailConfirmationMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"emailconfirmation\"";
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

	public List<IEmailConfirmationModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT token, userid FROM \"emailconfirmation\"")
			.map(new EmailConfirmationMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"emailconfirmation\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



