package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class UserMapper implements ResultSetMapper<IUserModel> {
	
	public IUserModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserModel(
			r.getString("username"),
			r.getString("password"),
			r.getString("name"),
			r.getString("prename"),
			r.getString("email"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
