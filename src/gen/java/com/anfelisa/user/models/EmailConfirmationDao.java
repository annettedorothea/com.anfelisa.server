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
public class EmailConfirmationDao {
	
	public void insert(Handle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.createStatement("INSERT INTO public.emailconfirmation (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(Handle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.createStatement("UPDATE public.emailconfirmation SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.bind("token",  emailConfirmationModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(Handle handle, String token) {
		Update statement = handle.createStatement("DELETE FROM public.emailconfirmation WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IEmailConfirmationModel selectByToken(Handle handle, String token) {
		return handle.createQuery("SELECT token, userid FROM public.emailconfirmation WHERE token = :token")
			.bind("token", token)
			.map(new EmailConfirmationMapper())
			.first();
	}
	
	public List<IEmailConfirmationModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT token, userid FROM public.emailconfirmation")
			.map(new EmailConfirmationMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.emailconfirmation CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
