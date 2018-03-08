package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserUpdateMapper implements ResultSetMapper<IUserUpdateModel> {
	
	public IUserUpdateModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserUpdateModel(
			r.getString("username"),
			r.getString("name"),
			r.getString("prename"),
			r.getString("email")
		);
	}
}

/*       S.D.G.       */
