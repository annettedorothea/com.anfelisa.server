/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ConfirmEmailMapper extends AbstractMapper<IConfirmEmailModel> {
	
	public IConfirmEmailModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ConfirmEmailModel(
			this.mapToString(r, "username"),
			this.mapToString(r, "token"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



