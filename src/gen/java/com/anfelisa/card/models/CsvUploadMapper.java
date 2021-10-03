/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CsvUploadMapper extends AbstractMapper<ICsvUploadModel> {
	
	public ICsvUploadModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CsvUploadModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "categoryId"),
			null,
			null
		);
	}
}



/******* S.D.G. *******/



