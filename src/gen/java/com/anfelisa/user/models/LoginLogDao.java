package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class LoginLogDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.loginlog (loginLogId serial NOT NULL  , username character varying NOT NULL  , date timestamp with time zone NOT NULL  , CONSTRAINT loginlog_pkey PRIMARY KEY (loginLogId), CONSTRAINT loginlog_loginLogId_unique UNIQUE (loginLogId))");
	}
	
	public Integer insert(Handle handle, ILoginLogModel loginLogModel) {
		if (loginLogModel.getLoginLogId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.loginlog (loginLogId, username, date) VALUES (:loginLogId, :username, :date)");
			statement.bind("loginLogId", loginLogModel.getLoginLogId());
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.loginlog_loginLogId_seq', (SELECT MAX(loginLogId) FROM anfelisa.loginlog));").execute();
			return loginLogModel.getLoginLogId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.loginlog (username, date) VALUES (:username, :date) RETURNING loginLogId");
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("loginLogId");
		}
	}
	
	
	public void updateByLoginLogId(Handle handle, ILoginLogModel loginLogModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.loginlog SET loginLogId = :loginLogId, username = :username, date = :date WHERE loginLogId = :loginLogId");
		statement.bind("loginLogId", loginLogModel.getLoginLogId());
		statement.bind("username", loginLogModel.getUsername());
		statement.bind("date", loginLogModel.getDate());
		statement.execute();
	}

	public void deleteByLoginLogId(Handle handle, Integer loginLogId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.loginlog WHERE loginLogId = :loginLogId");
		statement.bind("loginLogId", loginLogId);
		statement.execute();
	}

	public ILoginLogModel selectByLoginLogId(Handle handle, Integer loginLogId) {
		return handle.createQuery("SELECT * FROM anfelisa.loginlog WHERE loginLogId = :loginLogId")
			.bind("loginLogId", loginLogId)
			.map(new LoginLogMapper())
			.first();
	}
	
	public List<ILoginLogModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.loginlog")
			.map(new LoginLogMapper())
			.list();
	}
}

/*       S.D.G.       */
