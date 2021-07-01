/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class DeleteBoxMapper extends AbstractMapper<IDeleteBoxModel> {
	
	public IDeleteBoxModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteBoxModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			this.mapToString(r, "rootCategoryId")
		);
	}
}



/******* S.D.G. *******/



