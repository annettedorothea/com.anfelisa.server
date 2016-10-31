package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class UserDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".user (id serial , username character varying , password character varying , name character varying , prename character varying , email character varying , role character varying , emailConfirmed boolean , emailConfirmationHash character varying , CONSTRAINT user_pkey PRIMARY KEY (id), CONSTRAINT user_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, IUserModel userModel, String schema) {
		Update statement = handle.createStatement("INSERT INTO " + schema + ".user (id, username, password, name, prename, email, role, emailConfirmed, emailConfirmationHash) VALUES (:id, :username, :password, :name, :prename, :email, :role, :emailConfirmed, :emailConfirmationHash)");
		statement.bind("id", userModel.getId());
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getPassword());
		statement.bind("name", userModel.getName());
		statement.bind("prename", userModel.getPrename());
		statement.bind("email", userModel.getEmail());
		statement.bind("role", userModel.getRole());
		statement.bind("emailConfirmed", userModel.getEmailConfirmed());
		statement.bind("emailConfirmationHash", userModel.getEmailConfirmationHash());
		statement.execute();
	}
	
	public static void update(Handle handle, IUserModel userModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".user SET id = :id, username = :username, password = :password, name = :name, prename = :prename, email = :email, role = :role, emailConfirmed = :emailConfirmed, emailConfirmationHash = :emailConfirmationHash");
		statement.bind("id", userModel.getId());
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getPassword());
		statement.bind("name", userModel.getName());
		statement.bind("prename", userModel.getPrename());
		statement.bind("email", userModel.getEmail());
		statement.bind("role", userModel.getRole());
		statement.bind("emailConfirmed", userModel.getEmailConfirmed());
		statement.bind("emailConfirmationHash", userModel.getEmailConfirmationHash());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, IUserModel userModel, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".user WHERE id = :id");
		statement.bind("id", userModel.getId());
		statement.execute();
	}

	public static IUserModel selectById(Handle handle, IUserModel userModel, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".user WHERE id = :id")
			.bind("id", userModel.getId())
			.map(new UserMapper())
			.first();
	}
	
	public static List<IUserModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".user")
			.map(new UserMapper())
			.list();
	}
}

/*       S.D.G.       */
