package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class BoxConfigMapper implements ResultSetMapper<IBoxConfigModel> {
	
	public IBoxConfigModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxConfigModel(
			r.getInt("boxId")
		);
	}
}

/*       S.D.G.       */
