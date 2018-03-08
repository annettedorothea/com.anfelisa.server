package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class StatisticsItemMapper implements ResultSetMapper<IStatisticsItemModel> {
	
	public IStatisticsItemModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new StatisticsItemModel(
			r.getString("type"),
			r.getBoolean("isBox"),
			r.getInt("count"),
			r.getInt("day"),
			r.getString("name"),
			r.getInt("points"),
			r.getInt("maxPoints"),
			r.getInt("rate")
		);
	}
}

/*       S.D.G.       */
