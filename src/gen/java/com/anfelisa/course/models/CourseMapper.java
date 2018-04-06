package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CourseMapper implements ResultSetMapper<ICourseModel> {
	
	public ICourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseModel(
			r.getString("courseId"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getString("author")
		);
	}
}

/*       S.D.G.       */
