/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserRegistrationMapper extends AbstractMapper<IUserRegistrationModel> {
	
	public IUserRegistrationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserRegistrationModel(
			this.mapToString(r, "language"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "username"),
			this.mapToString(r, "password"),
			this.mapToString(r, "email"),
			this.mapToString(r, "role"),
			this.mapToBoolean(r, "emailConfirmed"),
			this.mapToString(r, "token")
		);
	}
}



/******* S.D.G. *******/



