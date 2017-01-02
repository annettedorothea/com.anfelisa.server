package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class UserDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".user (username character varying NOT NULL  , password character varying NOT NULL  , name character varying NOT NULL  , prename character varying NOT NULL  , email character varying NOT NULL  , role character varying NOT NULL  , emailConfirmed boolean NOT NULL  , CONSTRAINT user_pkey PRIMARY KEY (username), CONSTRAINT user_username_unique UNIQUE (username))");
	}
	
	public static void insert(Handle handle, IUserModel userModel, String schema) {
		if (userModel.getUsername() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".user (username, password, name, prename, email, role, emailConfirmed) VALUES (:username, :password, :name, :prename, :email, :role, :emailConfirmed)");
			statement.bind("username", userModel.getUsername());
			statement.bind("password", userModel.getPassword());
			statement.bind("name", userModel.getName());
			statement.bind("prename", userModel.getPrename());
			statement.bind("email", userModel.getEmail());
			statement.bind("role", userModel.getRole());
			statement.bind("emailConfirmed", userModel.getEmailConfirmed());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".user (password, name, prename, email, role, emailConfirmed) VALUES (:password, :name, :prename, :email, :role, :emailConfirmed)");
			statement.bind("password", userModel.getPassword());
			statement.bind("name", userModel.getName());
			statement.bind("prename", userModel.getPrename());
			statement.bind("email", userModel.getEmail());
			statement.bind("role", userModel.getRole());
			statement.bind("emailConfirmed", userModel.getEmailConfirmed());
			statement.execute();
		}
	}
	
	
	public static void updateByUsername(Handle handle, IUserModel userModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".user SET username = :username, password = :password, name = :name, prename = :prename, email = :email, role = :role, emailConfirmed = :emailConfirmed WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("password", userModel.getUsername());
		statement.bind("name", userModel.getUsername());
		statement.bind("prename", userModel.getUsername());
		statement.bind("email", userModel.getUsername());
		statement.bind("role", userModel.getUsername());
		statement.bind("emailConfirmed", userModel.getUsername());
		statement.execute();
	}

	public static void deleteByUsername(Handle handle, String username, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".user WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public static IUserModel selectByUsername(Handle handle, String username, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".user WHERE username = :username")
			.bind("username", username)
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
