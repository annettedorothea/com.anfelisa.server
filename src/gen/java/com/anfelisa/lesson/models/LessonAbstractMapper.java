package com.anfelisa.lesson.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class LessonAbstractMapper implements ResultSetMapper<ILessonAbstractModel> {
	
	public ILessonAbstractModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new LessonAbstractModel(
			r.getString("lessonName"),
			r.getString("lessonDescription"),
			r.getString("lessonAuthor"),
			r.getString("lessonId")
		);
	}
}

/*       S.D.G.       */
