package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class BoxDao {
	
	public void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".box (boxId serial NOT NULL  , name character varying NOT NULL  , username character varying NOT NULL  , CONSTRAINT box_pkey PRIMARY KEY (boxId), CONSTRAINT box_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT box_boxId_unique UNIQUE (boxId))");
	}
	
	public Integer insert(Handle handle, IBoxModel boxModel, String schema) {
		if (boxModel.getBoxId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".box (boxId, name, username) VALUES (:boxId, :name, :username)");
			statement.bind("boxId", boxModel.getBoxId());
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".box_boxId_seq', (SELECT MAX(boxId) FROM " + schema + ".box));").execute();
			return boxModel.getBoxId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO " + schema + ".box (name, username) VALUES (:name, :username) RETURNING boxId");
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("boxId");
		}
	}
	
	
	public static void updateByBoxId(Handle handle, IBoxModel boxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".box SET boxId = :boxId, name = :name, username = :username WHERE boxId = :boxId");
		statement.bind("boxId", boxModel.getBoxId());
		statement.bind("name", boxModel.getName());
		statement.bind("username", boxModel.getUsername());
		statement.execute();
	}

	public static void deleteByBoxId(Handle handle, Integer boxId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".box WHERE boxId = :boxId");
		statement.bind("boxId", boxId);
		statement.execute();
	}

	public static IBoxModel selectByBoxId(Handle handle, Integer boxId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".box WHERE boxId = :boxId")
			.bind("boxId", boxId)
			.map(new BoxMapper())
			.first();
	}
	
	public static List<IBoxModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".box")
			.map(new BoxMapper())
			.list();
	}
}

/*       S.D.G.       */
