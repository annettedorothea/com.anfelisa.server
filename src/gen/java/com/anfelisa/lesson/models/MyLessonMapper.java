package com.anfelisa.lesson.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class MyLessonMapper implements ResultSetMapper<IMyLessonModel> {
	
	public IMyLessonModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyLessonModel(
			r.getInt("lessonId"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getInt("openTests"),
			r.getBoolean("hasOpenTests")
		);
	}
}

/*       S.D.G.       */
