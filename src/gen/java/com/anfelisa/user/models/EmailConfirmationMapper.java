package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class EmailConfirmationMapper implements ResultSetMapper<IEmailConfirmationModel> {
	
	public IEmailConfirmationModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new EmailConfirmationModel(
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
