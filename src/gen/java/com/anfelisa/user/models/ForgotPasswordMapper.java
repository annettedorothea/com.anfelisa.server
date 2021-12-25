/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ForgotPasswordMapper extends AbstractMapper<IForgotPasswordModel> {
	
	public IForgotPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ForgotPasswordModel(
			this.mapToString(r, "language"),
			this.mapToString(r, "email"),
			this.mapToString(r, "username"),
			this.mapToString(r, "token"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



