package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CourseIdMapper implements ResultSetMapper<ICourseIdModel> {
	
	public ICourseIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseIdModel(
			r.getString("courseId")
		);
	}
}

/*       S.D.G.       */
