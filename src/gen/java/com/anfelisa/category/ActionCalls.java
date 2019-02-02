package com.anfelisa.category;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class ActionCalls {

	public static Response callCreateCategory(String uuid, String categoryName, String parentCategoryId, Boolean dictionaryLookup, String givenLanguage, String wantedLanguage, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/create", port)).request(); 
		com.anfelisa.category.data.ICategoryCreationData data = new com.anfelisa.category.data.CategoryCreationData(uuid);
		data.setCategoryName(categoryName);
		data.setParentCategoryId(parentCategoryId);
		data.setDictionaryLookup(dictionaryLookup);
		data.setGivenLanguage(givenLanguage);
		data.setWantedLanguage(wantedLanguage);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateCategory(String uuid, String categoryId, String categoryName, Boolean dictionaryLookup, String givenLanguage, String wantedLanguage, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/update?uuid=" + uuid, port)).request();
		com.anfelisa.category.data.ICategoryUpdateData data = new com.anfelisa.category.data.CategoryUpdateData(uuid);
		data.setCategoryId(categoryId);
		data.setCategoryName(categoryName);
		data.setDictionaryLookup(dictionaryLookup);
		data.setGivenLanguage(givenLanguage);
		data.setWantedLanguage(wantedLanguage);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteCategory(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/delete?uuid=" + uuid + "&categoryId=" + categoryId, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callInviteUser(String uuid, String categoryId, String invitedUsername, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/invite", port)).request(); 
		com.anfelisa.category.data.IInviteUserData data = new com.anfelisa.category.data.InviteUserData(uuid);
		data.setCategoryId(categoryId);
		data.setInvitedUsername(invitedUsername);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callRevokeUserAccess(String uuid, String revokedUserId, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/revoke?uuid=" + uuid + "&revokedUserId=" + revokedUserId + "&categoryId=" + categoryId, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callGetUsersWithAccess(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/users?uuid=" + uuid + "&categoryId=" + categoryId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetCategoryTree(String uuid, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/tree?uuid=" + uuid, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCategory(String uuid, String movedCategoryId, String targetCategoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/move?uuid=" + uuid, port)).request();
		com.anfelisa.category.data.ICategoryMoveData data = new com.anfelisa.category.data.CategoryMoveData(uuid);
		data.setMovedCategoryId(movedCategoryId);
		data.setTargetCategoryId(targetCategoryId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	
}

