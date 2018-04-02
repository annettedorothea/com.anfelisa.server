package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class BoxOfCourseMapper implements ResultSetMapper<IBoxOfCourseModel> {
	
	public IBoxOfCourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxOfCourseModel(
			r.getString("boxId"),
			r.getString("courseId"),
			r.getBoolean("autoAdd")
		);
	}
}

/*       S.D.G.       */
