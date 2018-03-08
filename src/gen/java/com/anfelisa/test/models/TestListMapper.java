package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class TestListMapper implements ResultSetMapper<ITestListModel> {
	
	public ITestListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new TestListModel(
		);
	}
}

/*       S.D.G.       */
