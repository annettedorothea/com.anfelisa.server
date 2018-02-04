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
	
	public Integer insert(Handle handle, IResultModel resultModel) {
		Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.result (username, testid, date, json, points, maxpoints) VALUES (:username, :testid, :date, :json, :points, :maxpoints) RETURNING resultid");
		statement.bind("username",  resultModel.getUsername() );
		statement.bind("testid",  resultModel.getTestId() );
		statement.bind("date",  resultModel.getDate() );
		statement.bind("json",  resultModel.getJson() );
		statement.bind("points",  resultModel.getPoints() );
		statement.bind("maxpoints",  resultModel.getMaxPoints() );
		Map<String, Object> first = statement.first();
		return (Integer) first.get("resultid");
	}
	
	
	public void updateByResultId(Handle handle, IResultModel resultModel) {
		Update statement = handle.createStatement("UPDATE public.result SET username = :username, testid = :testid, date = :date, json = :json, points = :points, maxpoints = :maxpoints WHERE resultid = :resultid");
		statement.bind("username",  resultModel.getUsername() );
		statement.bind("testid",  resultModel.getTestId() );
		statement.bind("date",  resultModel.getDate() );
		statement.bind("json",  resultModel.getJson() );
		statement.bind("points",  resultModel.getPoints() );
		statement.bind("maxpoints",  resultModel.getMaxPoints() );
		statement.bind("resultid",  resultModel.getResultId()  );
		statement.execute();
	}

	public void deleteByResultId(Handle handle, Integer resultId) {
		Update statement = handle.createStatement("DELETE FROM public.result WHERE resultid = :resultid");
		statement.bind("resultid", resultId);
		statement.execute();
	}

	public IResultModel selectByResultId(Handle handle, Integer resultId) {
		return handle.createQuery("SELECT resultid, username, testid, date, json, points, maxpoints FROM public.result WHERE resultid = :resultid")
			.bind("resultid", resultId)
			.map(new ResultMapper())
			.first();
	}
	
	public List<IResultModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT resultid, username, testid, date, json, points, maxpoints FROM public.result")
			.map(new ResultMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.result CASCADE");
		statement.execute();
		statement = handle.createStatement("ALTER SEQUENCE public.result_resultId_seq RESTART");
		statement.execute();
	}

}

/*       S.D.G.       */
