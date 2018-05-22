package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScoreMapper implements ResultSetMapper<IScoreModel> {
	
	public IScoreModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreModel(
			r.getInt("cards"),
			r.getInt("cardsForToday"),
			r.getInt("cardsForTomorrow"),
			r.getInt("cardsToBeReinforced"),
			r.getInt("zero"),
			r.getInt("one"),
			r.getInt("two"),
			r.getInt("three"),
			r.getInt("four"),
			r.getInt("five"),
			r.getInt("noQuality")
		);
	}
}

/*       S.D.G.       */
