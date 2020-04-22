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

	public static Response callCreateBox(
			com.anfelisa.box.data.IBoxCreationData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/create", port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateBox(
			com.anfelisa.box.data.IBoxUpdateData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/update?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callGetBoxSettings(
			com.anfelisa.box.data.IBoxSettingsWrapperData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/settings/" + data.getBoxId() + "/?uuid=" + data.getUuid(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callScheduleCards(
			com.anfelisa.box.data.IScheduledCardsData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/schedule", port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callScoreCard(
			com.anfelisa.box.data.IScoreCardData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/score", port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callScoreReinforceCard(
			com.anfelisa.box.data.IScoreReinforceCardData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/score-reinforce", port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callInitMyBoxesForDay(
			com.anfelisa.box.data.IInitMyBoxesDataData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/init?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callGetBoxes(
			com.anfelisa.box.data.IBoxListData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/boxes/my/?uuid=" + data.getUuid() + "&today=" + data.getToday(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callLoadNextCard(
			com.anfelisa.box.data.INextCardData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/next-card?uuid=" + data.getUuid() + "&boxId=" + data.getBoxId() + "&today=" + data.getToday(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callDeleteBox(
			com.anfelisa.box.data.IDeleteBoxData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/box/delete?uuid=" + data.getUuid() + "&boxId=" + data.getBoxId(), port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	
}




/******* S.D.G. *******/



