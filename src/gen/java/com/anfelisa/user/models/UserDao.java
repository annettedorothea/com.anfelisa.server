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
	
	public void insert(Handle handle, IUserModel userModel) {
		Update statement = handle.createStatement("INSERT INTO public.user (username, password, email, role, emailconfirmed, deleted) VALUES (:username, :password, :email, :role, :emailconfirmed, :deleted)");
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("deleted",  userModel.getDeleted() );
		statement.execute();
	}
	
	
	public void updateByUsername(Handle handle, IUserModel userModel) {
		Update statement = handle.createStatement("UPDATE public.user SET username = :username, password = :password, email = :email, role = :role, emailconfirmed = :emailconfirmed, deleted = :deleted WHERE username = :username");
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("deleted",  userModel.getDeleted() );
		statement.bind("username",  userModel.getUsername()  );
		statement.execute();
	}

	public void deleteByUsername(Handle handle, String username) {
		Update statement = handle.createStatement("DELETE FROM public.user WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public IUserModel selectByUsername(Handle handle, String username) {
		return handle.createQuery("SELECT username, password, email, role, emailconfirmed, deleted FROM public.user WHERE username = :username")
			.bind("username", username)
			.map(new UserMapper())
			.first();
	}
	
	public List<IUserModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT username, password, email, role, emailconfirmed, deleted FROM public.user")
			.map(new UserMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.user CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
