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
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.user.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractResetPasswordDao {
	
	public void insert(PersistenceHandle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"resetpassword\" (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(PersistenceHandle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"resetpassword\" SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.bind("token",  resetPasswordModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(PersistenceHandle handle, String token) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"resetpassword\" WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IResetPasswordModel selectByToken(PersistenceHandle handle, String token) {
		Optional<IResetPasswordModel> optional = handle.getHandle().createQuery("SELECT token, userid FROM \"resetpassword\" WHERE token = :token")
			.bind("token", token)
			.map(new ResetPasswordMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public IResetPasswordModel selectByPrimaryKey(PersistenceHandle handle, String token) {
		Optional<IResetPasswordModel> optional = handle.getHandle().createQuery("SELECT token, userid FROM \"resetpassword\" WHERE token = :token")
			.bind("token", token)
			.map(new ResetPasswordMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"resetpassword\"";
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

	public List<IResetPasswordModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT token, userid FROM \"resetpassword\"")
			.map(new ResetPasswordMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"resetpassword\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/



