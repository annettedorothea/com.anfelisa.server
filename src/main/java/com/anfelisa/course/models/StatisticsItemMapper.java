package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class StatisticsItemMapper implements ResultSetMapper<IStatisticsItemModel> {

	public IStatisticsItemModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new StatisticsItemModel(r.getString("type"), (r.getString("type").equals("box")), r.getInt("count"),
				new DateTime(r.getDate("timestamp")).getDayOfMonth(),
				r.getString("name"), r.getInt("points"), r.getInt("maxPoints"),
				(r.getInt("points") * 100 / r.getInt("maxPoints")));
	}
}
