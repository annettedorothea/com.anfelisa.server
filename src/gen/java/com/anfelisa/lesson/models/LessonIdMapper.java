package com.anfelisa.lesson.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class LessonIdMapper implements ResultSetMapper<ILessonIdModel> {
	
	public ILessonIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LessonIdModel(
			r.getString("lessonId")
		);
	}
}

/*       S.D.G.       */
