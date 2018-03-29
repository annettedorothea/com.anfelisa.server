package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CourseToBoxAdditionListMapper implements ResultSetMapper<ICourseToBoxAdditionListModel> {
	
	public ICourseToBoxAdditionListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CourseToBoxAdditionListModel(
			r.getInt("boxId"),
			r.getString("boxName"),
			null
		);
	}
}

/*       S.D.G.       */
