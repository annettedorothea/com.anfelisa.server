/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryChangeOrderMapper implements RowMapper<ICategoryChangeOrderModel> {
	
	public ICategoryChangeOrderModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryChangeOrderModel(
			r.getString("movedCategoryId"),
			r.getString("targetCategoryId"),
			r.getString("userId"),
			null
		);
	}
}



/******* S.D.G. *******/



