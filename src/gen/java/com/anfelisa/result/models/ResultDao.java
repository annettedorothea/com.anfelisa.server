package com.anfelisa.result.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class ResultDao {
	
	public void create(Handle handle, String schema) {
		handle.execute("CREATE TABLE IF NOT EXISTS " + schema + ".result (resultId serial NOT NULL  , username character varying NOT NULL  , testId integer NOT NULL  , date timestamp with time zone NOT NULL  , json character varying NOT NULL  , points integer NOT NULL  , maxPoints integer NOT NULL  , CONSTRAINT result_pkey PRIMARY KEY (resultId), CONSTRAINT result_username_fkey FOREIGN KEY (username) REFERENCES " + schema + ".user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_testId_fkey FOREIGN KEY (testId) REFERENCES " + schema + ".test ( testId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_resultId_unique UNIQUE (resultId))");
	}
	
	public Integer insert(Handle handle, IResultModel resultModel, String schema) {
		if (resultModel.getResultId() != null) {
			Update statement = handle.createStatement("INSERT INTO " + schema + ".result (resultId, username, testId, date, json, points, maxPoints) VALUES (:resultId, :username, :testId, :date, :json, :points, :maxPoints)");
			statement.bind("resultId", resultModel.getResultId());
			statement.bind("username", resultModel.getUsername());
			statement.bind("testId", resultModel.getTestId());
			statement.bind("date", resultModel.getDate());
			statement.bind("json", resultModel.getJson());
			statement.bind("points", resultModel.getPoints());
			statement.bind("maxPoints", resultModel.getMaxPoints());
			statement.execute();
			handle.createStatement("SELECT setval('" + schema + ".result_resultId_seq', (SELECT MAX(resultId) FROM " + schema + ".result));").execute();
			return resultModel.getResultId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO " + schema + ".result (username, testId, date, json, points, maxPoints) VALUES (:username, :testId, :date, :json, :points, :maxPoints) RETURNING resultId");
			statement.bind("username", resultModel.getUsername());
			statement.bind("testId", resultModel.getTestId());
			statement.bind("date", resultModel.getDate());
			statement.bind("json", resultModel.getJson());
			statement.bind("points", resultModel.getPoints());
			statement.bind("maxPoints", resultModel.getMaxPoints());
			Map<String, Object> first = statement.first();
			return (Integer) first.get("resultId");
		}
	}
	
	
	public static void updateByResultId(Handle handle, IResultModel resultModel, String schema) {
		Update statement = handle.createStatement("UPDATE " + schema + ".result SET resultId = :resultId, username = :username, testId = :testId, date = :date, json = :json, points = :points, maxPoints = :maxPoints WHERE resultId = :resultId");
		statement.bind("resultId", resultModel.getResultId());
		statement.bind("username", resultModel.getUsername());
		statement.bind("testId", resultModel.getTestId());
		statement.bind("date", resultModel.getDate());
		statement.bind("json", resultModel.getJson());
		statement.bind("points", resultModel.getPoints());
		statement.bind("maxPoints", resultModel.getMaxPoints());
		statement.execute();
	}

	public static void deleteByResultId(Handle handle, Integer resultId, String schema) {
		Update statement = handle.createStatement("DELETE FROM " + schema + ".result WHERE resultId = :resultId");
		statement.bind("resultId", resultId);
		statement.execute();
	}

	public static IResultModel selectByResultId(Handle handle, Integer resultId, String schema) {
		return handle.createQuery("SELECT * FROM " + schema + ".result WHERE resultId = :resultId")
			.bind("resultId", resultId)
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
