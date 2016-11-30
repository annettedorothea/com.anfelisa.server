package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;

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

}
