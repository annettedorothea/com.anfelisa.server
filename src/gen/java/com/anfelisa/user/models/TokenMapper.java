/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class TokenMapper extends AbstractMapper<ITokenModel> {
	
	public ITokenModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new TokenModel(
			this.mapToString(r, "username"),
			this.mapToString(r, "password"),
			this.mapToString(r, "token")
		);
	}
}



/******* S.D.G. *******/



