package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class UserAccessToCategoryMapper implements ResultSetMapper<IUserAccessToCategoryModel> {
	
	public IUserAccessToCategoryModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UserAccessToCategoryModel(
			r.getString("categoryId"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
