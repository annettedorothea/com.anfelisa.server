/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardTranslationMapper extends AbstractMapper<ICardTranslationModel> {
	
	public ICardTranslationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardTranslationModel(
			this.mapToString(r, "sourceValue"),
			this.mapToString(r, "targetValue"),
			this.mapToString(r, "sourceLanguage"),
			this.mapToString(r, "targetLanguage")
		);
	}
}



/******* S.D.G. *******/



