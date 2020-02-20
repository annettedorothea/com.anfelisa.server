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




package com.anfelisa.box;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

@SuppressWarnings("unused")
public class ActionCalls {

	public static Response callGetBoxes(String uuid, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/boxes/my/?uuid=" + uuid + "&today=" + today, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetBoxSettings(String uuid, String boxId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/settings/" + boxId + "/?uuid=" + uuid, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
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
	
	public static Response callInitMyBoxesForDay(String uuid, org.joda.time.DateTime today, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/init?uuid=" + uuid, port)).request();
		com.anfelisa.box.data.IInitMyBoxesDataData data = new com.anfelisa.box.data.InitMyBoxesDataData(uuid);
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
	
	public static Response callScoreReinforceCard(String uuid, String reinforceCardId, Integer scoredCardQuality, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/score-reinforce", port)).request(); 
		com.anfelisa.box.data.IScoreReinforceCardData data = new com.anfelisa.box.data.ScoreReinforceCardData(uuid);
		data.setReinforceCardId(reinforceCardId);
		data.setScoredCardQuality(scoredCardQuality);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	
}




/******* S.D.G. *******/



