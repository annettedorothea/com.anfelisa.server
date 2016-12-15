package com.anfelisa.box.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class StudentOfBoxDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".studentofbox (studentOfBoxId serial NOT NULL  , name character varying NOT NULL  , username character varying NOT NULL  , CONSTRAINT studentofbox_pkey PRIMARY KEY (studentOfBoxId), CONSTRAINT studentofbox_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT studentofbox_studentOfBoxId_unique UNIQUE (studentOfBoxId))");
	}
	
	public static void insert(Handle handle, IStudentOfBoxModel studentOfBoxModel, String schema) {
		if (studentOfBoxModel.getStudentOfBoxId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".studentofbox (studentOfBoxId, name, username) VALUES (:studentOfBoxId, :name, :username)");
			statement.bind("studentOfBoxId", studentOfBoxModel.getStudentOfBoxId());
			statement.bind("name", studentOfBoxModel.getName());
			statement.bind("username", studentOfBoxModel.getUsername());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".studentofbox_studentOfBoxId_seq', (SELECT MAX(studentOfBoxId) FROM " + schema + ".studentofbox));").execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".studentofbox (name, username) VALUES (:name, :username)");
			statement.bind("name", studentOfBoxModel.getName());
			statement.bind("username", studentOfBoxModel.getUsername());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, IStudentOfBoxModel studentOfBoxModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".studentofbox SET studentOfBoxId = :studentOfBoxId, name = :name, username = :username");
		statement.bind("studentOfBoxId", studentOfBoxModel.getStudentOfBoxId());
		statement.bind("name", studentOfBoxModel.getName());
		statement.bind("username", studentOfBoxModel.getUsername());
		statement.execute();
	}
	
	public static void deleteByStudentOfBoxId(Handle handle, Integer studentOfBoxId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".studentofbox WHERE studentOfBoxId = :studentOfBoxId");
		statement.bind("studentOfBoxId", studentOfBoxId);
		statement.execute();
	}

	public static IStudentOfBoxModel selectByStudentOfBoxId(Handle handle, Integer studentOfBoxId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".studentofbox WHERE studentOfBoxId = :studentOfBoxId")
			.bind("studentOfBoxId", studentOfBoxId)
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
