package com.anfelisa.auth;

import java.security.Key;
import java.util.Optional;

import de.acegen.CustomAppConfiguration;
import de.acegen.auth.AuthUser;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class AceAuthenticator implements Authenticator<String, AuthUser> {

	private CustomAppConfiguration configuration;

	public AceAuthenticator(CustomAppConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@Override
	public Optional<AuthUser> authenticate(String token) throws AuthenticationException {
		try {
			Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(configuration.getSecretString()));
			Jws<Claims> claims = Jwts.parserBuilder()
				.requireIssuer("anfelisa")
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token);
			String userId = claims.getBody().getSubject();
			String role = claims.getBody().get("role").toString();
			String username = claims.getBody().get("username").toString();
			return Optional.of(new AuthUser(userId, username, role));
		} catch (InvalidClaimException ice) {
			return Optional.empty();
		}
	}
}
