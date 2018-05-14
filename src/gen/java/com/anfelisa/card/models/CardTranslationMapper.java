package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardTranslationMapper implements ResultSetMapper<ICardTranslationModel> {
	
	public ICardTranslationModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardTranslationModel(
			r.getString("sourceValue"),
			r.getString("targetValue"),
			r.getString("sourceLanguage"),
			r.getString("targetLanguage")
		);
	}
}

/*       S.D.G.       */
