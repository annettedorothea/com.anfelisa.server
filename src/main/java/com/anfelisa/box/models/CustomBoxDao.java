package com.anfelisa.box.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomBoxDao {
	
	public static List<IBoxModel> selectByUsername(Handle handle, String schema, String username) {
		return handle.createQuery("SELECT * FROM " + schema + ".box where username = :username")
			.bind("username", username)
			.map(new BoxMapper())
			.list();
	}
}

/*       S.D.G.       */
