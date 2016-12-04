package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class StudentOfBoxMapper implements ResultSetMapper<IStudentOfBoxModel> {
	
	public IStudentOfBoxModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new StudentOfBoxModel(
			r.getInt("studentOfBoxId"),
			r.getString("name"),
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
