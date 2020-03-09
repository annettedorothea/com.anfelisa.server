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




package com.anfelisa.user.models;

import com.anfelisa.ace.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
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



