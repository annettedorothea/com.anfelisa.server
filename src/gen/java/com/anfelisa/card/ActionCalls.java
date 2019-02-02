package com.anfelisa.card;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class ActionCalls {

	public static Response callCreateCard(String uuid, String wanted, String given, String image, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/create", port)).request(); 
		com.anfelisa.card.data.ICardCreationData data = new com.anfelisa.card.data.CardCreationData(uuid);
		data.setWanted(wanted);
		data.setGiven(given);
		data.setImage(image);
		data.setCategoryId(categoryId);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateCard(String uuid, String cardId, String given, String image, String wanted, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/update?uuid=" + uuid, port)).request();
		com.anfelisa.card.data.ICardUpdateData data = new com.anfelisa.card.data.CardUpdateData(uuid);
		data.setCardId(cardId);
		data.setGiven(given);
		data.setImage(image);
		data.setWanted(wanted);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteCard(String uuid, String cardId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/delete?uuid=" + uuid + "&cardId=" + cardId, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callGetDuplicates(String uuid, String given, String wanted, Boolean naturalInputOrder, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/search?uuid=" + uuid + "&given=" + given + "&wanted=" + wanted + "&naturalInputOrder=" + naturalInputOrder + "&categoryId=" + categoryId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetTranslation(String uuid, String sourceValue, String sourceLanguage, String targetLanguage, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/translation?uuid=" + uuid + "&sourceValue=" + sourceValue + "&sourceLanguage=" + sourceLanguage + "&targetLanguage=" + targetLanguage, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetCards(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards?uuid=" + uuid + "&categoryId=" + categoryId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCards(String uuid, java.util.List<String> cardIdList, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/move?uuid=" + uuid, port)).request();
		com.anfelisa.card.data.ICardIdListData data = new com.anfelisa.card.data.CardIdListData(uuid);
		data.setCardIdList(cardIdList);
		data.setCategoryId(categoryId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	
}

