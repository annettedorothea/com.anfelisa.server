package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class ReinforceCardListMapper implements ResultSetMapper<IReinforceCardListModel> {
	
	public IReinforceCardListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardListModel(
			r.getString("boxId"),
			r.getString("boxName"),
			null
		);
	}
}

/*       S.D.G.       */
