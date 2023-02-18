/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardUpdateMapper extends AbstractMapper<CardUpdateModel> {
	
	public CardUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardUpdateModel(
			this.mapToString(r, "cardId"),
			this.mapToString(r, "given"),
			this.mapToString(r, "wanted"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



