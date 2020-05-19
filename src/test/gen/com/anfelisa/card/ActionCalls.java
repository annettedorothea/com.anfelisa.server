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




package com.anfelisa.card;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

@SuppressWarnings("unused")
public class ActionCalls {

	public static Response callCreateCard(
			com.anfelisa.card.data.ICardCreationData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/card/create", protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		Response response = builder.post(Entity.json(data));
		client.close();
		return response;
	}
	
	public static Response callUpdateCard(
			com.anfelisa.card.data.ICardUpdateData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/card/update?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		Response response = builder.put(Entity.json(data));
		client.close();
		return response;
	}
	
	public static Response callDeleteCard(
			com.anfelisa.card.data.ICardDeleteData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/card/delete?uuid=" + data.getUuid() + "&cardId=" + data.getCardId(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		Response response = builder.delete();
		client.close();
		return response;
	}
	
	public static Response callGetCards(
			com.anfelisa.card.data.ICardListData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/cards?uuid=" + data.getUuid() + "&categoryId=" + data.getCategoryId(), protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		Response response = builder.get();
		client.close();
		return response;
	}
	
	public static Response callGetDuplicates(
			com.anfelisa.card.data.ICardSearchData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/cards/search?uuid=" + data.getUuid() + "&given=" + data.getGiven() + "&wanted=" + data.getWanted() + "&naturalInputOrder=" + data.getNaturalInputOrder() + "&categoryId=" + data.getCategoryId(), protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		Response response = builder.get();
		client.close();
		return response;
	}
	
	public static Response callMoveCards(
			com.anfelisa.card.data.IMoveCardsData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/cards/move?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		Response response = builder.put(Entity.json(data));
		client.close();
		return response;
	}
	
	public static Response callChangeOrder(
			com.anfelisa.card.data.IChangeCardOrderListData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/cards/changeorder?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		Response response = builder.put(Entity.json(data));
		client.close();
		return response;
	}
	
	public static Response callImportCsv(
			com.anfelisa.card.data.ICsvUploadData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/import-csv?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		Response response = builder.put(Entity.json(data));
		client.close();
		return response;
	}
	
	public static Response callGetTranslation(
			com.anfelisa.card.data.ICardTranslationData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/card/translation?uuid=" + data.getUuid() + "&sourceValue=" + data.getSourceValue() + "&sourceLanguage=" + data.getSourceLanguage() + "&targetLanguage=" + data.getTargetLanguage(), protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		Response response = builder.get();
		client.close();
		return response;
	}
	
	
}




/******* S.D.G. *******/



