/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.commands;

import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.ITokenData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class GetTokenCommand extends AbstractGetTokenCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetTokenCommand.class);

	public GetTokenCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected ITokenData executeCommand(ITokenData data, PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, data.getUsername());
		if (user != null && user.getPassword().equals(data.getPassword()) /* && user.getEmailConfirmed() */) {
			Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(appConfiguration.getSecretString()));
			String token = Jwts.builder()
					.setIssuer("anfelisa")
					.setSubject(user.getUserId())
					.claim("role", user.getRole())
					.claim("username", user.getUsername())
					.signWith(key)
					.compact();
			data.setToken(token);
		} else {
			throwSecurityException();
		}
		return data;
	}

}




/******* S.D.G. *******/


