package com.anfelisa.user.models;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractEmailConfirmationDao {
	
	public void insert(Handle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.createUpdate("INSERT INTO \"emailconfirmation\" (token, userid) VALUES (:token, :userid)");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.execute();
	}
	
	
	public void updateByToken(Handle handle, IEmailConfirmationModel emailConfirmationModel) {
		Update statement = handle.createUpdate("UPDATE \"emailconfirmation\" SET token = :token, userid = :userid WHERE token = :token");
		statement.bind("token",  emailConfirmationModel.getToken() );
		statement.bind("userid",  emailConfirmationModel.getUserId() );
		statement.bind("token",  emailConfirmationModel.getToken()  );
		statement.execute();
	}

	public void deleteByToken(Handle handle, String token) {
		Update statement = handle.createUpdate("DELETE FROM \"emailconfirmation\" WHERE token = :token");
		statement.bind("token", token);
		statement.execute();
	}

	public IEmailConfirmationModel selectByToken(Handle handle, String token) {
		Optional<IEmailConfirmationModel> optional = handle.createQuery("SELECT token, userid FROM \"emailconfirmation\" WHERE token = :token")
			.bind("token", token)
			.map(new EmailConfirmationMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<IEmailConfirmationModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT token, userid FROM \"emailconfirmation\"")
			.map(new EmailConfirmationMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createUpdate("TRUNCATE TABLE \"emailconfirmation\" CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
