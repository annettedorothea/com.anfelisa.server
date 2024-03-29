/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CategoryTreeItemMapper extends AbstractMapper<CategoryTreeItemModel> {
	
	public CategoryTreeItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryTreeItemModel(
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "categoryName"),
			this.mapToInteger(r, "categoryIndex"),
			this.mapToBoolean(r, "empty"),
			this.mapToString(r, "parentCategoryId"),
			this.mapToBoolean(r, "dictionaryLookup"),
			this.mapToString(r, "givenLanguage"),
			this.mapToString(r, "wantedLanguage"),
			this.mapToString(r, "rootCategoryId"),
			null,
			this.mapToInteger(r, "nonScheduledCount"),
			this.mapToBoolean(r, "editable")
		);
	}
}



/******* S.D.G. *******/



