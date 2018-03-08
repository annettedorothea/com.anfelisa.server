package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class StatisticsMapper implements ResultSetMapper<IStatisticsModel> {
	
	public IStatisticsModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new StatisticsModel(
			r.getString("username"),
			r.getInt("year"),
			r.getInt("month"),
			r.getInt("points"),
			r.getInt("maxPoints"),
			r.getInt("rate")
		);
	}
}

/*       S.D.G.       */
