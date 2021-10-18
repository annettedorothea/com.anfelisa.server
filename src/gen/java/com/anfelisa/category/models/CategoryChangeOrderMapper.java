/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CategoryChangeOrderMapper extends AbstractMapper<ICategoryChangeOrderModel> {
	
	public ICategoryChangeOrderModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryChangeOrderModel(
			this.mapToString(r, "movedCategoryId"),
			this.mapToString(r, "targetCategoryId"),
			this.mapToString(r, "userId"),
			null
		);
	}
}



/******* S.D.G. *******/



