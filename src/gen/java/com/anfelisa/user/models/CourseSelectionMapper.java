package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CourseSelectionMapper implements ResultSetMapper<ICourseSelectionModel> {
	
	public ICourseSelectionModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseSelectionModel(
			null
		);
	}
}

/*       S.D.G.       */
