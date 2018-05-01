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
public class ResetPasswordDao {
	
	public void insert(Handle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.createStatement("INSERT INTO public.resetpassword (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(Handle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.createStatement("UPDATE public.resetpassword SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.bind("token",  resetPasswordModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(Handle handle, String token) {
		Update statement = handle.createStatement("DELETE FROM public.resetpassword WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IResetPasswordModel selectByToken(Handle handle, String token) {
		return handle.createQuery("SELECT token, userid FROM public.resetpassword WHERE token = :token")
			.bind("token", token)
			.map(new ResetPasswordMapper())
			.first();
	}
	
	public List<IResetPasswordModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT token, userid FROM public.resetpassword")
			.map(new ResetPasswordMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.resetpassword CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
