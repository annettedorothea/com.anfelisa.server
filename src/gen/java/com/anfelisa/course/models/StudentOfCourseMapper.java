package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class StudentOfCourseMapper implements ResultSetMapper<IStudentOfCourseModel> {
	
	public IStudentOfCourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new StudentOfCourseModel(
			r.getString("username"),
			r.getInt("courseId")
		);
	}
}

/*       S.D.G.       */
