package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class LanguageMapper implements ResultSetMapper<ILanguageModel> {
	
	public ILanguageModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LanguageModel(
			r.getString("language")
		);
	}
}

/*       S.D.G.       */
