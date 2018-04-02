package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ForgotPasswordMapper implements ResultSetMapper<IForgotPasswordModel> {
	
	public IForgotPasswordModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ForgotPasswordModel(
			r.getString("username"),
			r.getString("email"),
			r.getString("password")
		);
	}
}

/*       S.D.G.       */
