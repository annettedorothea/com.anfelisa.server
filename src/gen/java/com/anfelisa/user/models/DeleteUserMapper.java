package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class DeleteUserMapper implements ResultSetMapper<IDeleteUserModel> {
	
	public IDeleteUserModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteUserModel(
			r.getString("deletedUsername")
		);
	}
}

/*       S.D.G.       */
