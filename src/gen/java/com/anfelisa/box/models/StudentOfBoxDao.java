package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class StudentOfBoxDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".studentofbox (id serial NOT NULL , name character varying NOT NULL , username character varying NOT NULL , CONSTRAINT studentofbox_pkey PRIMARY KEY (id), CONSTRAINT studentofbox_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT studentofbox_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, IStudentOfBoxModel studentOfBoxModel, String schema) {
		if (studentOfBoxModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".studentofbox (id, name, username) VALUES (:id, :name, :username)");
			statement.bind("id", studentOfBoxModel.getId());
			statement.bind("name", studentOfBoxModel.getName());
			statement.bind("username", studentOfBoxModel.getUsername());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".studentofbox (name, username) VALUES (:name, :username)");
			statement.bind("name", studentOfBoxModel.getName());
			statement.bind("username", studentOfBoxModel.getUsername());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, IStudentOfBoxModel studentOfBoxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".studentofbox SET id = :id, name = :name, username = :username");
		statement.bind("id", studentOfBoxModel.getId());
		statement.bind("name", studentOfBoxModel.getName());
		statement.bind("username", studentOfBoxModel.getUsername());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".studentofbox WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static IStudentOfBoxModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".studentofbox WHERE id = :id")
			.bind("id", id)
			.map(new StudentOfBoxMapper())
			.first();
	}
	
	public static List<IStudentOfBoxModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".studentofbox")
			.map(new StudentOfBoxMapper())
			.list();
	}
}

/*       S.D.G.       */
