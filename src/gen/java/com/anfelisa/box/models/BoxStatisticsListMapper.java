/********************************************************************************
 * generated by de.acegen 1.5.6
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
			this.mapToString(r, "userId"),
			this.mapToDateTime(r, "todayAtMidnightInUTC")
		);
	}
}



/******* S.D.G. *******/



