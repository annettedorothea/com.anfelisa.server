/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class MoveCardsMapper extends AbstractMapper<IMoveCardsModel> {
	
	public IMoveCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new MoveCardsModel(
			null,
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "userId"),
			null,
			null
		);
	}
}



/******* S.D.G. *******/



