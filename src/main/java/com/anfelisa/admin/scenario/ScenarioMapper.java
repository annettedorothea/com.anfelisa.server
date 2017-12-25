package com.anfelisa.admin.scenario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScenarioMapper implements ResultSetMapper<IScenarioModel> {
	
	public IScenarioModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScenarioModel(
			r.getInt("id"),
			r.getString("description"),
			r.getString("data"),
			r.getTimestamp("createdDateTime") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDateTime")) : null
		);
	}
}

/*       S.D.G.       */
