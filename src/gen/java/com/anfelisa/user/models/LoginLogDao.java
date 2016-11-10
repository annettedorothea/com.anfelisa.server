package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class LoginLogDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".loginlog (id serial NOT NULL , username character varying NOT NULL , date timestamp with time zone NOT NULL , CONSTRAINT loginlog_pkey PRIMARY KEY (id), CONSTRAINT loginlog_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, ILoginLogModel loginLogModel, String schema) {
		if (loginLogModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".loginlog (id, username, date) VALUES (:id, :username, :date)");
			statement.bind("id", loginLogModel.getId());
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".loginlog (username, date) VALUES (:username, :date)");
			statement.bind("username", loginLogModel.getUsername());
			statement.bind("date", loginLogModel.getDate());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, ILoginLogModel loginLogModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".loginlog SET id = :id, username = :username, date = :date");
		statement.bind("id", loginLogModel.getId());
		statement.bind("username", loginLogModel.getUsername());
		statement.bind("date", loginLogModel.getDate());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".loginlog WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static ILoginLogModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".loginlog WHERE id = :id")
			.bind("id", id)
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
