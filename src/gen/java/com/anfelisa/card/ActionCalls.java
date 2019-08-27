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
	
	public static Response callGetCards(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards?uuid=" + uuid + "&categoryId=" + categoryId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callGetDuplicates(String uuid, String given, String wanted, Boolean naturalInputOrder, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/search?uuid=" + uuid + "&given=" + given + "&wanted=" + wanted + "&naturalInputOrder=" + naturalInputOrder + "&categoryId=" + categoryId, port)).request(); 
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
	
	public static Response callChangeOrder(String uuid, java.util.List<String> cardIdList, String cardId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/cards/changeorder?uuid=" + uuid, port)).request();
		com.anfelisa.card.data.IChangeCardOrderListData data = new com.anfelisa.card.data.ChangeCardOrderListData(uuid);
		data.setCardIdList(cardIdList);
		data.setCardId(cardId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callImportCsv(String uuid, java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/import-csv?uuid=" + uuid, port)).request();
		com.anfelisa.card.data.ICsvUploadData data = new com.anfelisa.card.data.CsvUploadData(uuid);
		data.setPreviewCsv(previewCsv);
		data.setCategoryId(categoryId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	
}




/******* S.D.G. *******/



