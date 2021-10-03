/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserAccessToCategoryMapper extends AbstractMapper<IUserAccessToCategoryModel> {
	
	public IUserAccessToCategoryModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserAccessToCategoryModel(
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "userId"),
			this.mapToBoolean(r, "editable")
		);
	}
}



/******* S.D.G. *******/



