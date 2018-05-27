package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class LineMapper implements ResultSetMapper<ILineModel> {
	
	public ILineModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LineModel(
			null
		);
	}
}

/*       S.D.G.       */
