/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	private String userId;
	
	private String username;
	
	private String password;
	
	private String role;
	

	public AuthUser (
		String userId,
		String username,
		String password,
		String role
	) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

		public String getUserId() {
			return this.userId;
		}
	
		public String getUsername() {
			return this.username;
		}
	
		public String getPassword() {
			return this.password;
		}
	
		public String getRole() {
			return this.role;
		}
	
	public String getName() {
		return "AuthUser";
	}
}




/******* S.D.G. *******/



