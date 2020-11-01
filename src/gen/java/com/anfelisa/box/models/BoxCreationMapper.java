/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class BoxCreationMapper implements RowMapper<IBoxCreationModel> {
	
	public IBoxCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxCreationModel(
			r.getString("username"),
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getString("categoryAuthor"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getString("parentCategoryId"),
			r.getString("rootCategoryId"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("userId"),
			r.getBoolean("editable"),
			r.getString("boxId"),
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null,
			r.getObject("maxCardsPerDay") != null ? r.getInt("maxCardsPerDay") : null
		);
	}
}



/******* S.D.G. *******/



