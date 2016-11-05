package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class BoxDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".box (id serial NOT NULL , name character varying NOT NULL , username character varying NOT NULL , CONSTRAINT box_pkey PRIMARY KEY (id), CONSTRAINT box_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT box_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, IBoxModel boxModel, String schema) {
		if (boxModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".box (id, name, username) VALUES (:id, :name, :username)");
			statement.bind("id", boxModel.getId());
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".box (name, username) VALUES (:name, :username)");
			statement.bind("name", boxModel.getName());
			statement.bind("username", boxModel.getUsername());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, IBoxModel boxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".box SET id = :id, name = :name, username = :username");
		statement.bind("id", boxModel.getId());
		statement.bind("name", boxModel.getName());
		statement.bind("username", boxModel.getUsername());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".box WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static IBoxModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".box WHERE id = :id")
			.bind("id", id)
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
