package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ChangeUserRoleMapper implements ResultSetMapper<IChangeUserRoleModel> {
	
	public IChangeUserRoleModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ChangeUserRoleModel(
			r.getString("userId"),
			r.getString("role"),
			r.getString("authUserId"),
			r.getString("authRole")
		);
	}
}

/*       S.D.G.       */
