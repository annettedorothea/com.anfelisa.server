package com.anfelisa.result.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import java.util.List;

public class ResultDao {
	
	public static void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".result (id serial NOT NULL , username character varying NOT NULL , testId integer NOT NULL , date timestamp with time zone NOT NULL , json character varying NOT NULL , points integer NOT NULL , maxPoints integer NOT NULL , CONSTRAINT result_pkey PRIMARY KEY (id), CONSTRAINT result_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_testId_fkey FOREIGN KEY (testId) REFERENCES " + schema + ".test ( id ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_id_unique UNIQUE (id))");
	}
	
	public static void insert(Handle handle, IResultModel resultModel, String schema) {
		if (resultModel.getId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".result (id, username, testId, date, json, points, maxPoints) VALUES (:id, :username, :testId, :date, :json, :points, :maxPoints)");
			statement.bind("id", resultModel.getId());
			statement.bind("username", resultModel.getUsername());
			statement.bind("testId", resultModel.getTestId());
			statement.bind("date", resultModel.getDate());
			statement.bind("json", resultModel.getJson());
			statement.bind("points", resultModel.getPoints());
			statement.bind("maxPoints", resultModel.getMaxPoints());
			statement.execute();
		} else {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".result (username, testId, date, json, points, maxPoints) VALUES (:username, :testId, :date, :json, :points, :maxPoints)");
			statement.bind("username", resultModel.getUsername());
			statement.bind("testId", resultModel.getTestId());
			statement.bind("date", resultModel.getDate());
			statement.bind("json", resultModel.getJson());
			statement.bind("points", resultModel.getPoints());
			statement.bind("maxPoints", resultModel.getMaxPoints());
			statement.execute();
		}
	}
	
	public static void update(Handle handle, IResultModel resultModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".result SET id = :id, username = :username, testId = :testId, date = :date, json = :json, points = :points, maxPoints = :maxPoints");
		statement.bind("id", resultModel.getId());
		statement.bind("username", resultModel.getUsername());
		statement.bind("testId", resultModel.getTestId());
		statement.bind("date", resultModel.getDate());
		statement.bind("json", resultModel.getJson());
		statement.bind("points", resultModel.getPoints());
		statement.bind("maxPoints", resultModel.getMaxPoints());
		statement.execute();
	}
	
	public static void deleteById(Handle handle, Integer id, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".result WHERE id = :id");
		statement.bind("id", id);
		statement.execute();
	}

	public static IResultModel selectById(Handle handle, Integer id, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".result WHERE id = :id")
			.bind("id", id)
			.map(new ResultMapper())
			.first();
	}
	
	public static List<IResultModel> selectAll(Handle handle, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".result")
			.map(new ResultMapper())
			.list();
	}
}

/*       S.D.G.       */
