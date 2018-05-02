package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CategoryListMapper implements ResultSetMapper<ICategoryListModel> {
	
	public ICategoryListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryListModel(
			r.getString("parentCategoryId"),
			r.getString("grandParentCategoryId"),
			r.getString("parentCategoryName"),
			null
		);
	}
}

/*       S.D.G.       */
