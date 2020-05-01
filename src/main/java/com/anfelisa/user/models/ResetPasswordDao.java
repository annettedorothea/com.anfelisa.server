package com.anfelisa.user.models;

import org.jdbi.v3.core.statement.Update;

import de.acegen.PersistenceHandle;

public class ResetPasswordDao extends AbstractResetPasswordDao {

	public void insert(PersistenceHandle handle, String token, String userId) {
		Update statement = handle.getHandle()
				.createUpdate("INSERT INTO \"resetpassword\" (token, userid) VALUES (:token, :userid)");
		statement.bind("token", token);
		statement.bind("userid", userId);
		statement.execute();
	}

}

/* S.D.G. */
