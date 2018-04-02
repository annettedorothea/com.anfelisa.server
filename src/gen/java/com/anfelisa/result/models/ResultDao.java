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
	
	public void insert(Handle handle, IResultModel resultModel) {
		Update statement = handle.createStatement("INSERT INTO public.result (resultid, username, testid, date, json, points, maxpoints) VALUES (:resultid, :username, :testid, :date, :json, :points, :maxpoints)");
		statement.bind("resultid",  resultModel.getResultId() );
		statement.bind("username",  resultModel.getUsername() );
		statement.bind("testid",  resultModel.getTestId() );
		statement.bind("date",  resultModel.getDate() );
		statement.bind("json",  resultModel.getJson() );
		statement.bind("points",  resultModel.getPoints() );
		statement.bind("maxpoints",  resultModel.getMaxPoints() );
		statement.execute();
	}
	
	
	public void updateByResultId(Handle handle, IResultModel resultModel) {
		Update statement = handle.createStatement("UPDATE public.result SET resultid = :resultid, username = :username, testid = :testid, date = :date, json = :json, points = :points, maxpoints = :maxpoints WHERE resultid = :resultid");
		statement.bind("resultid",  resultModel.getResultId() );
		statement.bind("username",  resultModel.getUsername() );
		statement.bind("testid",  resultModel.getTestId() );
		statement.bind("date",  resultModel.getDate() );
		statement.bind("json",  resultModel.getJson() );
		statement.bind("points",  resultModel.getPoints() );
		statement.bind("maxpoints",  resultModel.getMaxPoints() );
		statement.bind("resultid",  resultModel.getResultId()  );
		statement.execute();
	}

	public void deleteByResultId(Handle handle, String resultId) {
		Update statement = handle.createStatement("DELETE FROM public.result WHERE resultid = :resultid");
		statement.bind("resultid", resultId);
		statement.execute();
	}

	public IResultModel selectByResultId(Handle handle, String resultId) {
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
	}

}

/*       S.D.G.       */
