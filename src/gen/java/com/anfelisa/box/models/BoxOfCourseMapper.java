package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.DateTime;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BoxOfCourseMapper implements ResultSetMapper<IBoxOfCourseModel> {
	
	public IBoxOfCourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxOfCourseModel(
			r.getInt("boxId"),
			r.getInt("courseId"),
			r.getBoolean("autoAdd")
		);
	}
}

/*       S.D.G.       */
