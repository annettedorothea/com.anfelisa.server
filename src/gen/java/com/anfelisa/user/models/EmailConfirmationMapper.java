/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class EmailConfirmationMapper extends AbstractMapper<IEmailConfirmationModel> {
	
	public IEmailConfirmationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new EmailConfirmationModel(
			this.mapToString(r, "token"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



