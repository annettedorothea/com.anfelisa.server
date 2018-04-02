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
	
	public void insert(Handle handle, ILoginLogModel loginLogModel) {
		Update statement = handle.createStatement("INSERT INTO public.loginlog (loginlogid, username, date) VALUES (:loginlogid, :username, :date)");
		statement.bind("loginlogid",  loginLogModel.getLoginLogId() );
		statement.bind("username",  loginLogModel.getUsername() );
		statement.bind("date",  loginLogModel.getDate() );
		statement.execute();
	}
	
	
	public void updateByLoginLogId(Handle handle, ILoginLogModel loginLogModel) {
		Update statement = handle.createStatement("UPDATE public.loginlog SET loginlogid = :loginlogid, username = :username, date = :date WHERE loginlogid = :loginlogid");
		statement.bind("loginlogid",  loginLogModel.getLoginLogId() );
		statement.bind("username",  loginLogModel.getUsername() );
		statement.bind("date",  loginLogModel.getDate() );
		statement.bind("loginlogid",  loginLogModel.getLoginLogId()  );
		statement.execute();
	}

	public void deleteByLoginLogId(Handle handle, String loginLogId) {
		Update statement = handle.createStatement("DELETE FROM public.loginlog WHERE loginlogid = :loginlogid");
		statement.bind("loginlogid", loginLogId);
		statement.execute();
	}

	public ILoginLogModel selectByLoginLogId(Handle handle, String loginLogId) {
		return handle.createQuery("SELECT loginlogid, username, date FROM public.loginlog WHERE loginlogid = :loginlogid")
			.bind("loginlogid", loginLogId)
			.map(new LoginLogMapper())
			.first();
	}
	
	public List<ILoginLogModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT loginlogid, username, date FROM public.loginlog")
			.map(new LoginLogMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.loginlog CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
