package com.anfelisa.result.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ResultDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.result (resultId serial NOT NULL  , username character varying NOT NULL  , testId integer NOT NULL  , date timestamp with time zone NOT NULL  , json character varying NOT NULL  , points integer NOT NULL  , maxPoints integer NOT NULL  , CONSTRAINT result_pkey PRIMARY KEY (resultId), CONSTRAINT result_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_testId_fkey FOREIGN KEY (testId) REFERENCES anfelisa.test ( testId ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_resultId_unique UNIQUE (resultId))");
	}
	
	public Integer insert(Handle handle, IResultModel resultModel) {
		if (resultModel.getResultId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.result (resultId, username, testId, date, json, points, maxPoints) VALUES (:resultId, :username, :testId, :date, :json, :points, :maxPoints)");
			statement.bind("resultId", resultModel.getResultId());
			statement.bind("username", resultModel.getUsername());
			statement.bind("testId", resultModel.getTestId());
			statement.bind("date", resultModel.getDate());
			statement.bind("json", resultModel.getJson());
			statement.bind("points", resultModel.getPoints());
			statement.bind("maxPoints", resultModel.getMaxPoints());
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.result_resultId_seq', (SELECT MAX(resultId) FROM anfelisa.result));").execute();
			return resultModel.getResultId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.result (username, testId, date, json, points, maxPoints) VALUES (:username, :testId, :date, :json, :points, :maxPoints) RETURNING resultId");
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
	
	
	public void updateByResultId(Handle handle, IResultModel resultModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.result SET resultId = :resultId, username = :username, testId = :testId, date = :date, json = :json, points = :points, maxPoints = :maxPoints WHERE resultId = :resultId");
		statement.bind("resultId", resultModel.getResultId());
		statement.bind("username", resultModel.getUsername());
		statement.bind("testId", resultModel.getTestId());
		statement.bind("date", resultModel.getDate());
		statement.bind("json", resultModel.getJson());
		statement.bind("points", resultModel.getPoints());
		statement.bind("maxPoints", resultModel.getMaxPoints());
		statement.execute();
	}

	public void deleteByResultId(Handle handle, Integer resultId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.result WHERE resultId = :resultId");
		statement.bind("resultId", resultId);
		statement.execute();
	}

	public IResultModel selectByResultId(Handle handle, Integer resultId) {
		return handle.createQuery("SELECT * FROM anfelisa.result WHERE resultId = :resultId")
			.bind("resultId", resultId)
			.map(new ResultMapper())
			.first();
	}
	
	public List<IResultModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.result")
			.map(new ResultMapper())
			.list();
	}
}

/*       S.D.G.       */
