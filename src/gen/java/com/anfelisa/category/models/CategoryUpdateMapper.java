/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CategoryUpdateMapper extends AbstractMapper<ICategoryUpdateModel> {
	
	public ICategoryUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryUpdateModel(
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "categoryName"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



