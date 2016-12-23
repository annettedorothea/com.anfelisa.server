package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.user.data.UserUpdateData;

public class CustomUserDao {

	public static int selectTestPoints(Handle handle, String username, String schema) {
		return handle
				.createQuery("select sum(points) as sum from " + schema + ".result WHERE username = :username")
				.bind("username", username)
				.mapTo(Integer.class).first();
	}

	public static int selectBoxPoints(Handle handle, String username, String schema) {
		return handle
				.createQuery("SELECT sum(points) as sum FROM " + schema + ".cardofbox c, " + schema
						+ ". box b where c.boxid = b.boxid AND b.username = :username")
				.bind("username", username)
				.mapTo(Integer.class).first();
	}

	public static void update(Handle handle, UserUpdateData userModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".user SET name = :name, prename = :prename, email = :email WHERE username = :username");
		statement.bind("username", userModel.getUsername());
		statement.bind("name", userModel.getName());
		statement.bind("prename", userModel.getPrename());
		statement.bind("email", userModel.getEmail());
		statement.execute();
	}

}
