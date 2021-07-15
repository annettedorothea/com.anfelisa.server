/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserMapper extends AbstractMapper<IUserModel> {
	
	public IUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "username"),
			this.mapToString(r, "password"),
			this.mapToString(r, "email"),
			this.mapToString(r, "role"),
			this.mapToBoolean(r, "emailConfirmed")
		);
	}
}



/******* S.D.G. *******/



