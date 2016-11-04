package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CourseMapper implements ResultSetMapper<ICourseModel> {
	
	public ICourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseModel(
			r.getLong("id"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getBoolean("isPublic")
		);
	}
}

/*       S.D.G.       */
