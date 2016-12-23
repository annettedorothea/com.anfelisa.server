package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class LoginLogDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".loginlog (loginLogId serial NOT NULL  , username character varying NOT NULL  , date timestamp with time zone NOT NULL  , CONSTRAINT loginlog_pkey PRIMARY KEY (loginLogId), CONSTRAINT loginlog_loginLogId_unique UNIQUE (loginLogId))");
	}
	
	public static void insert(Handle handle, ILoginLogModel loginLogModel, String schema) {
		if (loginLogModel.getLoginLogId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".loginlog (loginLogId, username, date) VALUES (:loginLogId, :username, :date)");
			statement.bind("loginLogId", loginLogModel.getLoginLogId());
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".loginlog_loginLogId_seq', (SELECT MAX(loginLogId) FROM " + schema + ".loginlog));").execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".loginlog (username, date) VALUES (:username, :date)");
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			statement.execute();
		}
	}
	
	
	public static void updateByLoginLogId(Handle handle, ILoginLogModel loginLogModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".loginlog SET loginLogId = :loginLogId, username = :username, date = :date WHERE loginLogId = :loginLogId");
		statement.bind("loginLogId", loginLogModel.getLoginLogId());
		statement.bind("username", loginLogModel.getLoginLogId());
		statement.bind("date", loginLogModel.getLoginLogId());
		statement.execute();
	}

	public static void deleteByLoginLogId(Handle handle, Integer loginLogId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".loginlog WHERE loginLogId = :loginLogId");
		statement.bind("loginLogId", loginLogId);
		statement.execute();
	}

	public static ILoginLogModel selectByLoginLogId(Handle handle, Integer loginLogId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".loginlog WHERE loginLogId = :loginLogId")
			.bind("loginLogId", loginLogId)
			.map(new LoginLogMapper())
			.first();
	}
	
	public static List<ILoginLogModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".loginlog")
			.map(new LoginLogMapper())
			.list();
	}
}

/*       S.D.G.       */
