package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserRoleUpdateMapper implements ResultSetMapper<IUserRoleUpdateModel> {
	
	public IUserRoleUpdateModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserRoleUpdateModel(
			r.getString("editedUsername"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
