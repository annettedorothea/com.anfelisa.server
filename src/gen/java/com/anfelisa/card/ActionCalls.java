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

public class ActionCalls {

	public static Response callCreateCard(
			com.anfelisa.card.data.ICardCreationData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/create", port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateCard(
			com.anfelisa.card.data.ICardUpdateData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/update?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteCard(
			com.anfelisa.card.data.ICardDeleteData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/delete?uuid=" + data.getUuid() + "&cardId=" + data.getCardId(), port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callGetCards(
			com.anfelisa.card.data.ICardListData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards?uuid=" + data.getUuid() + "&categoryId=" + data.getCategoryId(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetDuplicates(
			com.anfelisa.card.data.ICardSearchData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/search?uuid=" + data.getUuid() + "&given=" + data.getGiven() + "&wanted=" + data.getWanted() + "&naturalInputOrder=" + data.getNaturalInputOrder() + "&categoryId=" + data.getCategoryId(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCards(
			com.anfelisa.card.data.IMoveCardsData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/move?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callChangeOrder(
			com.anfelisa.card.data.IChangeCardOrderListData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/changeorder?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callImportCsv(
			com.anfelisa.card.data.ICsvUploadData data, 
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/import-csv?uuid=" + data.getUuid(), port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callGetTranslation(
			com.anfelisa.card.data.ICardTranslationData data,
			int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/card/translation?uuid=" + data.getUuid() + "&sourceValue=" + data.getSourceValue() + "&sourceLanguage=" + data.getSourceLanguage() + "&targetLanguage=" + data.getTargetLanguage(), port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	
}




/******* S.D.G. *******/



