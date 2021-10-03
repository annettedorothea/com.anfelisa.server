/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardUpdatePriorityMapper extends AbstractMapper<ICardUpdatePriorityModel> {
	
	public ICardUpdatePriorityModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardUpdatePriorityModel(
			this.mapToString(r, "cardId"),
			this.mapToInteger(r, "priority"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



