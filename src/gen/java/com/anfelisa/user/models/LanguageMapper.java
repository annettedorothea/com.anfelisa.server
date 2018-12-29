package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class LanguageMapper implements RowMapper<ILanguageModel> {
	
	public ILanguageModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new LanguageModel(
			r.getString("language")
		);
	}
}

/*       S.D.G.       */
