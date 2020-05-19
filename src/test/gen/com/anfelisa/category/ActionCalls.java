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




package com.anfelisa.category;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

@SuppressWarnings("unused")
public class ActionCalls {

	public static Response callCreateCategory(
			com.anfelisa.category.data.ICategoryCreationData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/create", protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateCategory(
			com.anfelisa.category.data.ICategoryUpdateData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/update?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteCategory(
			com.anfelisa.category.data.ICategoryDeleteData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/delete?uuid=" + data.getUuid() + "&categoryId=" + data.getCategoryId(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callGetCategoryTree(
			com.anfelisa.category.data.ICategoryTreeData data,
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/tree?uuid=" + data.getUuid() + "&rootCategoryId=" + data.getRootCategoryId(), protocol, host, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCategory(
			com.anfelisa.category.data.ICategoryMoveData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/move?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callChangeOrderCategory(
			com.anfelisa.category.data.ICategoryChangeOrderData data, 
			String protocol, String host, int port, 
			String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("%s://%s:%d/api/category/changeorder?uuid=" + data.getUuid(), protocol, host, port)).request();
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	
}




/******* S.D.G. *******/



