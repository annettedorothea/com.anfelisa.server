package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class MyCourseMapper implements ResultSetMapper<IMyCourseModel> {
	
	public IMyCourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyCourseModel(
			r.getString("courseId"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getString("author"),
			r.getInt("openTests"),
			r.getBoolean("hasOpenTests")
		);
	}
}

/*       S.D.G.       */
