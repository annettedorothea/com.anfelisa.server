/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardDeleteItemMapper extends AbstractMapper<CardDeleteItemModel> {
	
	public CardDeleteItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardDeleteItemModel(
			this.mapToString(r, "cardId"),
			this.mapToInteger(r, "cardIndex"),
			this.mapToString(r, "categoryId")
		);
	}
}



/******* S.D.G. *******/



