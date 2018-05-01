package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class CourseToBoxAdditionMapper implements ResultSetMapper<ICourseToBoxAdditionModel> {
	
	public ICourseToBoxAdditionModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseToBoxAdditionModel(
			r.getString("boxId"),
			r.getString("courseId"),
			r.getBoolean("autoAdd"),
			r.getString("name")
		);
	}
}

/*       S.D.G.       */
