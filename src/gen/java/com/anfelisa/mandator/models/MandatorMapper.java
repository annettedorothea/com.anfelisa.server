package com.anfelisa.mandator.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MandatorMapper implements ResultSetMapper<IMandatorModel> {
	
	public IMandatorModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MandatorModel(
			r.getLong("id"),
			r.getString("mandatorId"),
			r.getString("username"),
			r.getString("password"),
			r.getString("name"),
			r.getString("prename"),
			r.getString("email"),
			r.getString("role"),
			r.getBoolean("emailConfirmed"),
			r.getString("emailConfirmationHash")
		);
	}
}

/*       S.D.G.       */
