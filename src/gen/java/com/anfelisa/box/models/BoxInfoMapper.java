package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class BoxInfoMapper implements RowMapper<IBoxInfoModel> {
	
	public IBoxInfoModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxInfoModel(
			r.getObject("todaysCards") != null ? r.getInt("todaysCards") : null,
			r.getObject("totalCards") != null ? r.getInt("totalCards") : null,
			r.getObject("reinforceCards") != null ? r.getInt("reinforceCards") : null,
			r.getObject("myCards") != null ? r.getInt("myCards") : null,
			r.getObject("daysBehindSchedule") != null ? r.getInt("daysBehindSchedule") : null,
			r.getString("boxId"),
			r.getString("categoryName"),
			r.getObject("maxInterval") != null ? r.getInt("maxInterval") : null,
			r.getObject("quality0Count") != null ? r.getInt("quality0Count") : null,
			r.getObject("quality1Count") != null ? r.getInt("quality1Count") : null,
			r.getObject("quality2Count") != null ? r.getInt("quality2Count") : null,
			r.getObject("quality3Count") != null ? r.getInt("quality3Count") : null,
			r.getObject("quality4Count") != null ? r.getInt("quality4Count") : null,
			r.getObject("quality5Count") != null ? r.getInt("quality5Count") : null
		);
	}
}

/*       S.D.G.       */
