/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryTreeMapper implements RowMapper<ICategoryTreeModel> {
	
	public ICategoryTreeModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryTreeModel(
			null,
			r.getString("userId"),
			r.getString("rootCategoryId")
		);
	}
}



/******* S.D.G. *******/



