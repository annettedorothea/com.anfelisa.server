package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CategoryMoveMapper implements ResultSetMapper<ICategoryMoveModel> {
	
	public ICategoryMoveModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryMoveModel(
			r.getString("categoryId"),
			r.getString("parentCategoryId")
		);
	}
}

/*       S.D.G.       */
