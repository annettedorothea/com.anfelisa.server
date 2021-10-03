/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserToCategoryInvitationMapper extends AbstractMapper<IUserToCategoryInvitationModel> {
	
	public IUserToCategoryInvitationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserToCategoryInvitationModel(
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "invitedUsername"),
			this.mapToString(r, "invitedUserId"),
			null
		);
	}
}



/******* S.D.G. *******/



