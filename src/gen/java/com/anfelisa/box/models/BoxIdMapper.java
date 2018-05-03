package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class BoxIdMapper implements ResultSetMapper<IBoxIdModel> {
	
	public IBoxIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxIdModel(
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
