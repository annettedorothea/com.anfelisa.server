package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class BoxInfoMapper implements ResultSetMapper<IBoxInfoModel> {
	
	public IBoxInfoModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxInfoModel(
			r.getObject("todaysCards") != null ? r.getInt("todaysCards") : null,
			r.getObject("totalCards") != null ? r.getInt("totalCards") : null,
			r.getObject("myCards") != null ? r.getInt("myCards") : null,
			r.getObject("daysBehindSchedule") != null ? r.getInt("daysBehindSchedule") : null,
			r.getString("boxId"),
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null
		);
	}
}

/*       S.D.G.       */
