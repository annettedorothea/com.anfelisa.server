/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserWithAccessListMapper extends AbstractMapper<IUserWithAccessListModel> {
	
	public IUserWithAccessListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserWithAccessListModel(
			this.mapToString(r, "categoryId"),
			null
		);
	}
}



/******* S.D.G. *******/



