/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class PostponeCardsMapper extends AbstractMapper<IPostponeCardsModel> {
	
	public IPostponeCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new PostponeCardsModel(
			this.mapToInteger(r, "days"),
			this.mapToString(r, "boxId")
		);
	}
}



/******* S.D.G. *******/



