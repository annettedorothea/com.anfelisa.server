package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class NextCardMapper implements ResultSetMapper<INextCardModel> {
	
	public INextCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new NextCardModel(
			r.getString("scheduledCardId"),
			r.getString("cardId"),
			r.getString("boxId"),
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scoredDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scoredDate")) : null
		);
	}
}

/*       S.D.G.       */
