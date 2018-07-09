package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class InviteUserMapper implements ResultSetMapper<IInviteUserModel> {
	
	public IInviteUserModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new InviteUserModel(
			r.getString("categoryId"),
			r.getString("invitedUserId"),
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
