/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UsernameAvailableMapper extends AbstractMapper<IUsernameAvailableModel> {
	
	public IUsernameAvailableModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameAvailableModel(
			this.mapToString(r, "username"),
			this.mapToBoolean(r, "available")
		);
	}
}



/******* S.D.G. *******/



