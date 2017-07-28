package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserMapper implements ResultSetMapper<IUserModel> {
	
	public IUserModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserModel(
			r.getString("username"),
			r.getString("password"),
			r.getString("name"),
			r.getString("prename"),
			r.getString("email"),
			r.getString("role"),
			r.getBoolean("emailConfirmed"),
			r.getBoolean("premium")
		);
	}
}

/*       S.D.G.       */
