package com.anfelisa.box;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class ActionCalls {

	public static Response callGetBoxes(String uuid, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/boxes/my/?uuid=" + uuid + "&today=" + today, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetBox(String uuid, String boxId, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/get?uuid=" + uuid + "&boxId=" + boxId + "&today=" + today, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callCreateBox(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/create", port)).request(); 
		com.anfelisa.box.data.IBoxData data = new com.anfelisa.box.data.BoxData(uuid);
		data.setCategoryId(categoryId);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateBox(String uuid, Integer maxInterval, Integer maxCardsPerDay, String boxId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/update?uuid=" + uuid, port)).request();
		com.anfelisa.box.data.IBoxUpdateData data = new com.anfelisa.box.data.BoxUpdateData(uuid);
		data.setMaxInterval(maxInterval);
		data.setMaxCardsPerDay(maxCardsPerDay);
		data.setBoxId(boxId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callPostponeCards(String uuid, String boxId, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/postpone?uuid=" + uuid, port)).request();
		com.anfelisa.box.data.IPostponeCardsData data = new com.anfelisa.box.data.PostponeCardsData(uuid);
		data.setBoxId(boxId);
		data.setToday(today);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteBox(String uuid, String boxId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/delete?uuid=" + uuid + "&boxId=" + boxId, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callLoadNextCard(String uuid, String boxId, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/next-card?uuid=" + uuid + "&boxId=" + boxId + "&today=" + today, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callLoadNextReinforceCard(String uuid, String boxId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/next-reinforce-card?uuid=" + uuid + "&boxId=" + boxId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callScheduleNextCard(String uuid, String boxId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/schedule-next", port)).request(); 
		com.anfelisa.box.data.IScheduleNextCardData data = new com.anfelisa.box.data.ScheduleNextCardData(uuid);
		data.setBoxId(boxId);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callScheduleCards(String uuid, java.util.List<String> cardIds, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/schedule", port)).request(); 
		com.anfelisa.box.data.IScheduledCardsData data = new com.anfelisa.box.data.ScheduledCardsData(uuid);
		data.setCardIds(cardIds);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callScoreCard(String uuid, String scoredCardScheduledCardId, String boxId, Integer scoredCardQuality, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/score", port)).request(); 
		com.anfelisa.box.data.IScoreCardData data = new com.anfelisa.box.data.ScoreCardData(uuid);
		data.setScoredCardScheduledCardId(scoredCardScheduledCardId);
		data.setBoxId(boxId);
		data.setScoredCardQuality(scoredCardQuality);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callScoreReinforceCard(String uuid, String reinforceCardId, Integer quality, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/reinforce-card/score", port)).request(); 
		com.anfelisa.box.data.IScoreReinforceCardData data = new com.anfelisa.box.data.ScoreReinforceCardData(uuid);
		data.setReinforceCardId(reinforceCardId);
		data.setQuality(quality);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	
}

