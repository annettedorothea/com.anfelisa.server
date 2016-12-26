package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CourseToBoxAdditionMapper implements ResultSetMapper<ICourseToBoxAdditionModel> {
	
	public ICourseToBoxAdditionModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseToBoxAdditionModel(
			r.getInt("boxId"),
			r.getInt("courseId"),
			(r.getObject("autoAdd") == null)? null : r.getBoolean("autoAdd"),
			r.getString("name")
		);
	}
}

/*       S.D.G.       */
