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




package com.anfelisa.user;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class ActionCalls {

	public static Response callRegisterUser(
			com.anfelisa.user.data.IUserRegistrationData data,
			int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/register", port)).request(); 
		return builder.post(Entity.json(data));
	}
	
	public static Response callGetRole(
			com.anfelisa.user.data.IRoleData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + data.getUuid(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callUsernameAvailable(
			com.anfelisa.user.data.IUsernameAvailableData data,
			int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/username?uuid=" + data.getUuid() + "&username=" + data.getUsername(), port)).request(); 
		return builder.get();
	}
	
	public static Response callConfirmEmail(
			com.anfelisa.user.data.IConfirmEmailData data, 
			int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/confirm?uuid=" + data.getUuid(), port)).request();
		return builder.put(Entity.json(data));
	}
	
	public static Response callGetUserProfile(
			com.anfelisa.user.data.IUserData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/get?uuid=" + data.getUuid(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetAllUsers(
			com.anfelisa.user.data.IUserListData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/all?uuid=" + data.getUuid(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callForgotPassword(
			com.anfelisa.user.data.IForgotPasswordData data,
			int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/forgot-password", port)).request(); 
		return builder.post(Entity.json(data));
	}
	
	public static Response callResetPassword(
			com.anfelisa.user.data.IResetPasswordWithNewPasswordData data, 
			int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/resetpassword?uuid=" + data.getUuid(), port)).request();
		return builder.put(Entity.json(data));
	}
	
	public static Response callChangeUserRole(
			com.anfelisa.user.data.IChangeUserRoleData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteUser(
			com.anfelisa.user.data.IDeleteUserData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/delete?uuid=" + data.getUuid() + "&usernameToBeDeleted=" + data.getUsernameToBeDeleted(), port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	
}




/******* S.D.G. *******/



