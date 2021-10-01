/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UsernameSearchMapper extends AbstractMapper<IUsernameSearchModel> {
	
	public IUsernameSearchModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameSearchModel(
			this.mapToString(r, "usernameSearchString"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "categoryId"),
			null
		);
	}
}



/******* S.D.G. *******/



