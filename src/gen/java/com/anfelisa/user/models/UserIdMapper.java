package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserIdMapper implements ResultSetMapper<IUserIdModel> {
	
	public IUserIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserIdModel(
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
