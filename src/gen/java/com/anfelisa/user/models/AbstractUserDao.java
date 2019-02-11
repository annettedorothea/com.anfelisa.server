/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractUserDao {
	
	public void insert(Handle handle, IUserModel userModel) {
		Update statement = handle.createUpdate("INSERT INTO \"user\" (userid, username, password, email, role, emailconfirmed) VALUES (:userid, :username, :password, :email, :role, :emailconfirmed)");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.execute();
	}
	
	
	public void updateByUserId(Handle handle, IUserModel userModel) {
		Update statement = handle.createUpdate("UPDATE \"user\" SET userid = :userid, username = :username, password = :password, email = :email, role = :role, emailconfirmed = :emailconfirmed WHERE userid = :userid");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("userid",  userModel.getUserId()  );
		statement.execute();
	}

	public void deleteByUserId(Handle handle, String userId) {
		Update statement = handle.createUpdate("DELETE FROM \"user\" WHERE userid = :userid");
		statement.bind("userid", userId);
		statement.execute();
	}

	public IUserModel selectByUserId(Handle handle, String userId) {
		Optional<IUserModel> optional = handle.createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\" WHERE userid = :userid")
			.bind("userid", userId)
			.map(new UserMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	public void updateByUsername(Handle handle, IUserModel userModel) {
		Update statement = handle.createUpdate("UPDATE \"user\" SET userid = :userid, username = :username, password = :password, email = :email, role = :role, emailconfirmed = :emailconfirmed WHERE username = :username");
		statement.bind("userid",  userModel.getUserId() );
		statement.bind("username",  userModel.getUsername() );
		statement.bind("password",  userModel.getPassword() );
		statement.bind("email",  userModel.getEmail() );
		statement.bind("role",  userModel.getRole() );
		statement.bind("emailconfirmed",  userModel.getEmailConfirmed() );
		statement.bind("username",  userModel.getUsername()  );
		statement.execute();
	}

	public void deleteByUsername(Handle handle, String username) {
		Update statement = handle.createUpdate("DELETE FROM \"user\" WHERE username = :username");
		statement.bind("username", username);
		statement.execute();
	}

	public IUserModel selectByUsername(Handle handle, String username) {
		Optional<IUserModel> optional = handle.createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\" WHERE username = :username")
			.bind("username", username)
			.map(new UserMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IUserModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT userid, username, password, email, role, emailconfirmed FROM \"user\"")
			.map(new UserMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"user\" CASCADE");
		statement.execute();
	}

}




/******* S.D.G. *******/



