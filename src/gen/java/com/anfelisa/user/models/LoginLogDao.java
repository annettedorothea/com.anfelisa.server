package com.anfelisa.user.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class LoginLogDao {
	
	public void create(Handle handle) {
		handle.execute("CREATE TABLE IF NOT EXISTS public.loginlog (loginlogid serial NOT NULL  , username character varying NOT NULL  , date timestamp with time zone NOT NULL  , CONSTRAINT loginlog_pkey PRIMARY KEY (loginlogid), CONSTRAINT loginlog_loginLogId_unique UNIQUE (loginLogId))");
	}
	
	public Integer insert(Handle handle, ILoginLogModel loginLogModel) {
		if (loginLogModel.getLoginLogId() != null) {
			Update statement = handle.createStatement("INSERT INTO public.loginlog (loginlogid, username, date) VALUES (:loginlogid, :username, :date)");
			statement.bind("loginlogid",  loginLogModel.getLoginLogId() );
			statement.bind("username",  loginLogModel.getUsername() );
			statement.bind("date",  loginLogModel.getDate() );
			statement.execute();
			handle.createStatement("SELECT setval('public.loginlog_loginlogid_seq', (SELECT MAX(loginlogid) FROM public.loginlog));").execute();
			return loginLogModel.getLoginLogId();
		} else {
			Query<Map<String, Object>> statement = handle.createQuery("INSERT INTO public.loginlog (username, date) VALUES (:username, :date) RETURNING loginlogid");
			statement.bind("username",  loginLogModel.getUsername() );
			statement.bind("date",  loginLogModel.getDate() );
			Map<String, Object> first = statement.first();
			return (Integer) first.get("loginlogid");
		}
	}
	
	
	public void updateByLoginLogId(Handle handle, ILoginLogModel loginLogModel) {
		Update statement = handle.createStatement("UPDATE public.loginlog SET loginlogid = :loginlogid, username = :username, date = :date WHERE loginlogid = :loginlogid");
		statement.bind("loginlogid",  loginLogModel.getLoginLogId() );
		statement.bind("username",  loginLogModel.getUsername() );
		statement.bind("date",  loginLogModel.getDate() );
		statement.execute();
	}

	public void deleteByLoginLogId(Handle handle, Integer loginLogId) {
		Update statement = handle.createStatement("DELETE FROM public.loginlog WHERE loginlogid = :loginlogid");
		statement.bind("loginlogid", loginLogId);
		statement.execute();
	}

	public ILoginLogModel selectByLoginLogId(Handle handle, Integer loginLogId) {
		return handle.createQuery("SELECT * FROM public.loginlog WHERE loginlogid = :loginlogid")
			.bind("loginlogid", loginLogId)
			.map(new LoginLogMapper())
			.first();
	}
	
	public List<ILoginLogModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT * FROM public.loginlog")
			.map(new LoginLogMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.loginlog");
		statement.execute();
	}

}

/*       S.D.G.       */
