package com.anfelisa.user;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

@SuppressWarnings("unused")
public class ActionCalls {

	public static Response callGetUserProfile(String uuid, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/get?uuid=" + uuid, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callUsernameAvailable(String uuid, String username, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/username?uuid=" + uuid + "&username=" + username, port)).request(); 
		return builder.get();
	}
	
	public static Response callGetRole(String uuid, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + uuid, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetAllUsers(String uuid, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/all?uuid=" + uuid, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callForgotPassword(String uuid, String username, String language, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/forgot-password", port)).request(); 
		com.anfelisa.user.data.IForgotPasswordData data = new com.anfelisa.user.data.ForgotPasswordData(uuid);
		data.setUsername(username);
		data.setLanguage(language);
		return builder.post(Entity.json(data));
	}
	
	public static Response callResetPassword(String uuid, String password, String token, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/resetpassword?uuid=" + uuid, port)).request();
		com.anfelisa.user.data.IResetPasswordWithNewPasswordData data = new com.anfelisa.user.data.ResetPasswordWithNewPasswordData(uuid);
		data.setPassword(password);
		data.setToken(token);
		return builder.put(Entity.json(data));
	}
	
	public static Response callRegisterUser(String uuid, String password, String username, String email, String language, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/register", port)).request(); 
		com.anfelisa.user.data.IUserRegistrationData data = new com.anfelisa.user.data.UserRegistrationData(uuid);
		data.setPassword(password);
		data.setUsername(username);
		data.setEmail(email);
		data.setLanguage(language);
		return builder.post(Entity.json(data));
	}
	
	public static Response callConfirmEmail(String uuid, String token, String username, int port) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/users/confirm?uuid=" + uuid, port)).request();
		com.anfelisa.user.data.IConfirmEmailData data = new com.anfelisa.user.data.ConfirmEmailData(uuid);
		data.setToken(token);
		data.setUsername(username);
		return builder.put(Entity.json(data));
	}
	
	public static Response callChangeUserRole(String uuid, String newRole, String editedUserId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/role?uuid=" + uuid, port)).request();
		com.anfelisa.user.data.IChangeUserRoleData data = new com.anfelisa.user.data.ChangeUserRoleData(uuid);
		data.setNewRole(newRole);
		data.setEditedUserId(editedUserId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteUser(String uuid, String usernameToBeDeleted, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/user/delete?uuid=" + uuid + "&usernameToBeDeleted=" + usernameToBeDeleted, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	
}

