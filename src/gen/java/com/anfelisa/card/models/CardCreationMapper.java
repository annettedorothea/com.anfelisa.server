/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardCreationMapper extends AbstractMapper<ICardCreationModel> {
	
	public ICardCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardCreationModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "username"),
			this.mapToString(r, "cardId"),
			this.mapToString(r, "given"),
			this.mapToString(r, "wanted"),
			this.mapToString(r, "cardAuthor"),
			this.mapToInteger(r, "cardIndex"),
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "rootCategoryId"),
			this.mapToInteger(r, "priority")
		);
	}
}



/******* S.D.G. *******/



