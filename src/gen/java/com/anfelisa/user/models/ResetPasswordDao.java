package com.anfelisa.user.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@SuppressWarnings("all")
@JsonIgnoreType
public class ResetPasswordDao {
	
	public void insert(Handle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.createUpdate("INSERT INTO public.resetpassword (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(Handle handle, IResetPasswordModel resetPasswordModel) {
		Update statement = handle.createUpdate("UPDATE public.resetpassword SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  resetPasswordModel.getToken() );
		statement.bind("userid",  resetPasswordModel.getUserId() );
		statement.bind("token",  resetPasswordModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(Handle handle, String token) {
		Update statement = handle.createUpdate("DELETE FROM public.resetpassword WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IResetPasswordModel selectByToken(Handle handle, String token) {
		Optional<IResetPasswordModel> optional = handle.createQuery("SELECT token, userid FROM public.resetpassword WHERE token = :token")
			.bind("token", token)
			.map(new ResetPasswordMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IResetPasswordModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT token, userid FROM public.resetpassword")
			.map(new ResetPasswordMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE public.resetpassword CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
