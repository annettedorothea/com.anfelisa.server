/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class CardWithStatisticsMapper extends AbstractMapper<ICardWithStatisticsModel> {
	
	public ICardWithStatisticsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CardWithStatisticsModel(
			this.mapToFloat(r, "ef"),
			this.mapToInteger(r, "interval"),
			this.mapToInteger(r, "count"),
			this.mapToInteger(r, "lastQuality"),
			this.mapToDateTime(r, "next"),
			this.mapToString(r, "cardId"),
			this.mapToString(r, "given"),
			this.mapToString(r, "wanted"),
			this.mapToString(r, "cardAuthor"),
			this.mapToInteger(r, "cardIndex"),
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "rootCategoryId"),
			this.mapToInteger(r, "priority")
		);
	}
}



/******* S.D.G. *******/



