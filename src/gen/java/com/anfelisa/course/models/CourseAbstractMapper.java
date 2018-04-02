package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CourseAbstractMapper implements ResultSetMapper<ICourseAbstractModel> {
	
	public ICourseAbstractModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseAbstractModel(
			r.getString("courseName"),
			r.getString("courseDescription"),
			r.getBoolean("isPublic"),
			r.getString("courseAuthor"),
			r.getString("courseId")
		);
	}
}

/*       S.D.G.       */
