package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class MyTestListMapper implements ResultSetMapper<IMyTestListModel> {
	
	public IMyTestListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyTestListModel(
			null
		);
	}
}

/*       S.D.G.       */
