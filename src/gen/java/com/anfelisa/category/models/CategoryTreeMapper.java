/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CategoryTreeMapper extends AbstractMapper<ICategoryTreeModel> {
	
	public ICategoryTreeModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryTreeModel(
			null,
			this.mapToString(r, "userId"),
			this.mapToString(r, "rootCategoryId"),
			this.mapToBoolean(r, "filterNonScheduled"),
			this.mapToInteger(r, "priority"),
			this.mapToBoolean(r, "editable"),
			this.mapToBoolean(r, "reverse"),
			this.mapToBoolean(r, "reverseBoxExists"),
			this.mapToString(r, "boxId")
		);
	}
}



/******* S.D.G. *******/



