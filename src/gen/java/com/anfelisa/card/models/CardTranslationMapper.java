package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CardTranslationMapper implements RowMapper<ICardTranslationModel> {
	
	public ICardTranslationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardTranslationModel(
			r.getString("sourceValue"),
			r.getString("targetValue"),
			r.getString("sourceLanguage"),
			r.getString("targetLanguage")
		);
	}
}

/*       S.D.G.       */
