package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class RevokeUserMapper implements ResultSetMapper<IRevokeUserModel> {
	
	public IRevokeUserModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new RevokeUserModel(
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getString("revokedUserId")
		);
	}
}

/*       S.D.G.       */
