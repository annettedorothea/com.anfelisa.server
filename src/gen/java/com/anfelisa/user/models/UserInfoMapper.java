/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class UserInfoMapper extends AbstractMapper<IUserInfoModel> {
	
	public IUserInfoModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserInfoModel(
			this.mapToString(r, "username")
		);
	}
}



/******* S.D.G. *******/



