package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserWithAccessMapper implements ResultSetMapper<IUserWithAccessModel> {
	
	public IUserWithAccessModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserWithAccessModel(
			r.getString("userId"),
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
