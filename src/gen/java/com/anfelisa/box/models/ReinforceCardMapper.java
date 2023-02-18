/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ReinforceCardMapper extends AbstractMapper<ReinforceCardModel> {
	
	public ReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardModel(
			this.mapToString(r, "reinforceCardId"),
			this.mapToString(r, "scheduledCardId"),
			this.mapToString(r, "boxId"),
			this.mapToDateTime(r, "changeDate")
		);
	}
}



/******* S.D.G. *******/



