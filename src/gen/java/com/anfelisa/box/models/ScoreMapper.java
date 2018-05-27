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
			r.getObject("cards") != null ? r.getInt("cards") : null,
			r.getObject("cardsForToday") != null ? r.getInt("cardsForToday") : null,
			r.getObject("cardsForTomorrow") != null ? r.getInt("cardsForTomorrow") : null,
			r.getObject("cardsToBeReinforced") != null ? r.getInt("cardsToBeReinforced") : null,
			r.getObject("zero") != null ? r.getInt("zero") : null,
			r.getObject("one") != null ? r.getInt("one") : null,
			r.getObject("two") != null ? r.getInt("two") : null,
			r.getObject("three") != null ? r.getInt("three") : null,
			r.getObject("four") != null ? r.getInt("four") : null,
			r.getObject("five") != null ? r.getInt("five") : null,
			r.getObject("noQuality") != null ? r.getInt("noQuality") : null
		);
	}
}

/*       S.D.G.       */
