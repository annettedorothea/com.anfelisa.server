package com.anfelisa.lesson.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MyLessonMapper implements ResultSetMapper<IMyLessonModel> {
	
	public IMyLessonModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyLessonModel(
			r.getInt("id"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getInt("openTests"),
			r.getInt("openTests") > 0
		);
	}
}

/*       S.D.G.       */
