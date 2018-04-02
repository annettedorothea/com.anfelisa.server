package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class LoginLogMapper implements ResultSetMapper<ILoginLogModel> {
	
	public ILoginLogModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LoginLogModel(
			r.getString("loginLogId"),
			r.getString("username"),
			r.getTimestamp("date") != null ? new org.joda.time.DateTime(r.getTimestamp("date")) : null
		);
	}
}

/*       S.D.G.       */
