package com.anfelisa.models;

import org.skife.jdbi.v2.Handle;

public class SchemaDao {

	public void createSchema(Handle handle, String schema) {
		handle.execute("create schema " + schema);
	}

}
