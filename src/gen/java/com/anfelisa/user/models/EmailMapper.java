package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class EmailMapper implements ResultSetMapper<IEmailModel> {
	
	public IEmailModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new EmailModel(
			r.getString("email")
		);
	}
}

/*       S.D.G.       */
