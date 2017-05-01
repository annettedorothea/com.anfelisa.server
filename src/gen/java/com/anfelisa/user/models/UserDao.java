package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class UserDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.user (username character varying NOT NULL  , password character varying NOT NULL  , name character varying NOT NULL  , prename character varying NOT NULL  , email character varying NOT NULL  , role character varying NOT NULL  , emailconfirmed boolean NOT NULL  , CONSTRAINT user_pkey PRIMARY KEY (username), CONSTRAINT user_username_unique UNIQUE (username))");
	}
	
	public String insert(Handle handle, IUserModel userModel) {
		if (userModel.getUsername() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.user (username, password, name, prename, email, role, emailconfirmed) VALUES (:username, :password, :name, :prename, :email, :role, :emailconfirmed)");
			statement.bind("username",  userModel.getUsername() );
			statement.bind("password",  userModel.getPassword() );
			statement.bind("name",  userModel.getName() );
			statement.bind("prename",  userModel.getPrename() );
			statement.bind("email",  userModel.getEmail() );
			statement.bind("role",  userModel.getRole() );
			statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
			statement.execute();
			return userModel.getUsername();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.user (password, name, prename, email, role, emailconfirmed) VALUES (:password, :name, :prename, :email, :role, :emailconfirmed) RETURNING username");
			statement.bind("password",  userModel.getPassword() );
			statement.bind("name",  userModel.getName() );
			statement.bind("prename",  userModel.getPrename() );
			statement.bind("email",  userModel.getEmail() );
			statement.bind("role",  userModel.getRole() );
			statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
			Map<String, Object> first = statement.first();
			return (String) first.get("username");
		}
	}
	
	
	public void updateByUsername(Handle handle, IUserModel userModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.user SET username = :username, password = :password, name = :name, prename = :prename, email = :email, role = :role, emailconfirmed = :emailconfirmed WHERE username = :username");
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getUsername() );
		statement.bind("name",  userModel.getUsername() );
		statement.bind("prename",  userModel.getUsername() );
		statement.bind("email",  userModel.getUsername() );
		statement.bind("role",  userModel.getUsername() );
		statement.bind("emailconfirmed",  userModel.getUsername() );
		statement.execute();
	}

	public void deleteByUsername(Handle handle, String username) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.user WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public IUserModel selectByUsername(Handle handle, String username) {
		return handle.createQuery("SELECT * FROM anfelisa.user WHERE username = :username")
			.bind("username", username)
			.map(new UserMapper())
			.first();
	}
	
	public List<IUserModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.user")
			.map(new UserMapper())
			.list();
	}
}

/*       S.D.G.       */
