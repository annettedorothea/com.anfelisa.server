package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class LoginLogMapper implements ResultSetMapper<ILoginLogModel> {
	
	public ILoginLogModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LoginLogModel(
			r.getInt("id"),
			r.getString("username"),
			new DateTime(r.getDate("date"))
		);
	}
}

/*       S.D.G.       */
