/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ResetPasswordMapper extends AbstractMapper<IResetPasswordModel> {
	
	public IResetPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ResetPasswordModel(
			this.mapToString(r, "token"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



