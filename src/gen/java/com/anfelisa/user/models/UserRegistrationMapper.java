package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserRegistrationMapper implements ResultSetMapper<IUserRegistrationModel> {
	
	public IUserRegistrationModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserRegistrationModel(
			r.getString("username"),
			r.getString("password"),
			r.getString("email"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
