package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DeleteUserMapper implements RowMapper<IDeleteUserModel> {
	
	public IDeleteUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new DeleteUserModel(
			r.getString("usernameToBeDeleted"),
			r.getString("username"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
