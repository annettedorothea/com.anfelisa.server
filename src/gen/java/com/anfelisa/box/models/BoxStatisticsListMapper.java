/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class BoxStatisticsListMapper extends AbstractMapper<IBoxStatisticsListModel> {
	
	public IBoxStatisticsListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxStatisticsListModel(
			null,
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



