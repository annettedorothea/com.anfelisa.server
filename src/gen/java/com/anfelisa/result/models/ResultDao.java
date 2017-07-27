package com.anfelisa.result.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class ResultDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS anfelisa.result (resultid serial NOT NULL  , username character varying NOT NULL  , testid integer NOT NULL  , date timestamp with time zone NOT NULL  , json character varying NOT NULL  , points integer NOT NULL  , maxpoints integer NOT NULL  , CONSTRAINT result_pkey PRIMARY KEY (resultid), CONSTRAINT result_username_fkey FOREIGN KEY (username) REFERENCES anfelisa.user ( username ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_testid_fkey FOREIGN KEY (testid) REFERENCES anfelisa.test ( testid ) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE, CONSTRAINT result_resultId_unique UNIQUE (resultId))");
	}
	
	public Integer insert(Handle handle, IResultModel resultModel) {
		if (resultModel.getResultId() != null) {
			Update statement = handle.createStatement("INSERT INTO anfelisa.result (resultid, username, testid, date, json, points, maxpoints) VALUES (:resultid, :username, :testid, :date, :json, :points, :maxpoints)");
			statement.bind("resultid",  resultModel.getResultId() );
			statement.bind("username",  resultModel.getUsername() );
			statement.bind("testid",  resultModel.getTestId() );
			statement.bind("date",  resultModel.getDate() );
			statement.bind("json",  resultModel.getJson() );
			statement.bind("points",  resultModel.getPoints() );
			statement.bind("maxpoints",  resultModel.getMaxPoints() );
			statement.execute();
			handle.createStatement("SELECT setval('anfelisa.result_resultid_seq', (SELECT MAX(resultid) FROM anfelisa.result));").execute();
			return resultModel.getResultId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO anfelisa.result (username, testid, date, json, points, maxpoints) VALUES (:username, :testid, :date, :json, :points, :maxpoints) RETURNING resultid");
			statement.bind("username",  resultModel.getUsername() );
			statement.bind("testid",  resultModel.getTestId() );
			statement.bind("date",  resultModel.getDate() );
			statement.bind("json",  resultModel.getJson() );
			statement.bind("points",  resultModel.getPoints() );
			statement.bind("maxpoints",  resultModel.getMaxPoints() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("resultid");
		}
	}
	
	
	public void updateByResultId(Handle handle, IResultModel resultModel) {
		Update statement = handle.createStatement("UPDATE anfelisa.result SET resultid = :resultid, username = :username, testid = :testid, date = :date, json = :json, points = :points, maxpoints = :maxpoints WHERE resultid = :resultid");
		statement.bind("resultid",  resultModel.getResultId() );
		statement.bind("username",  resultModel.getUsername() );
		statement.bind("testid",  resultModel.getTestId() );
		statement.bind("date",  resultModel.getDate() );
		statement.bind("json",  resultModel.getJson() );
		statement.bind("points",  resultModel.getPoints() );
		statement.bind("maxpoints",  resultModel.getMaxPoints() );
		statement.execute();
	}

	public void deleteByResultId(Handle handle, Integer resultId) {
		Update statement = handle.createStatement("DELETE FROM anfelisa.result WHERE resultid = :resultid");
		statement.bind("resultid", resultId);
		statement.execute();
	}

	public IResultModel selectByResultId(Handle handle, Integer resultId) {
		return handle.createQuery("SELECT * FROM anfelisa.result WHERE resultid = :resultid")
			.bind("resultid", resultId)
			.map(new ResultMapper())
			.first();
	}
	
	public List<IResultModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM anfelisa.result")
			.map(new ResultMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE anfelisa.result");
		statement.execute();
	}

}

/*       S.D.G.       */
