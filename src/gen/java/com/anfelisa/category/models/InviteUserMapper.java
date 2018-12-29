package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class InviteUserMapper implements RowMapper<IInviteUserModel> {
	
	public IInviteUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new InviteUserModel(
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getString("invitedUserId"),
			r.getString("invitedUsername"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
