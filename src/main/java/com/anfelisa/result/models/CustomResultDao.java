package com.anfelisa.result.models;

import java.util.List;

import org.skife.jdbi.v2.Handle;

public class CustomResultDao {

	public static List<IResultAbstractModel> selectByTestIdAndUsername(Handle handle, String schema, Integer testId, String username) {
		return handle.createQuery("SELECT * FROM " + schema + ".result WHERE testId = :testId AND username = :username ORDER BY date")
			.bind("testId", testId)
			.bind("username", username)
			.map(new ResultAbstractMapper())
			.list();
	}

}
