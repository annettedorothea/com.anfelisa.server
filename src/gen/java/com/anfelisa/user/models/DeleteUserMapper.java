/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class DeleteUserMapper extends AbstractMapper<IDeleteUserModel> {
	
	public IDeleteUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteUserModel(
			this.mapToString(r, "usernameToBeDeleted"),
			this.mapToString(r, "username"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "role"),
			null,
			null
		);
	}
}



/******* S.D.G. *******/



