/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class AlreadyInvitedUsernamesMapper extends AbstractMapper<IAlreadyInvitedUsernamesModel> {
	
	public IAlreadyInvitedUsernamesModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new AlreadyInvitedUsernamesModel(
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "userId"),
			null
		);
	}
}



/******* S.D.G. *******/



