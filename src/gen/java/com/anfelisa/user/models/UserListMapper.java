package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class UserListMapper implements ResultSetMapper<IUserListModel> {
	
	public IUserListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserListModel(
			null
		);
	}
}

/*       S.D.G.       */
