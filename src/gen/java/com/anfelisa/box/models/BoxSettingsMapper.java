/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class BoxSettingsMapper implements RowMapper<IBoxSettingsModel> {
	
	public IBoxSettingsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxSettingsModel(
			r.getString("boxId"),
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null,
			r.getObject("maxCardsPerDay") != null ? r.getInt("maxCardsPerDay") : null,
			r.getString("categoryName"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("categoryId"),
			r.getObject("allCards") != null ? r.getInt("allCards") : null,
			r.getObject("allActiveCards") != null ? r.getInt("allActiveCards") : null
		);
	}
}



/******* S.D.G. *******/



