package com.anfelisa.lesson.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class LessonMapper implements ResultSetMapper<ILessonModel> {
	
	public ILessonModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LessonModel(
			r.getInt("id"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getInt("courseId"),
			r.getString("author")
		);
	}
}

/*       S.D.G.       */
