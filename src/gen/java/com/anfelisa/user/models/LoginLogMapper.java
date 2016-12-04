package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class LoginLogMapper implements ResultSetMapper<ILoginLogModel> {
	
	public ILoginLogModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LoginLogModel(
			r.getInt("loginLogId"),
			r.getString("username"),
			new org.joda.time.DateTime(r.getDate("date"))
		);
	}
}

/*       S.D.G.       */
