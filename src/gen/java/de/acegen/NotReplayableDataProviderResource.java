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




package de.acegen;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;

@Path("/test/not-replayable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotReplayableDataProviderResource {

	static final Logger LOG = LoggerFactory.getLogger(NotReplayableDataProviderResource.class);

	public NotReplayableDataProviderResource() {
		super();
	}

	@PUT
	@Timed
	@Path("/value")
	public Response putValue(@QueryParam("uuid") String uuid, @QueryParam("key") String key, String json) {
		NotReplayableDataProvider.put(uuid, key, json);
		return Response.ok().build();
	}

	@PUT
	@Timed
	@Path("/system-time")
	public Response putSystemTime(@QueryParam("uuid") String uuid, DateTime systemTime) {
		NotReplayableDataProvider.putSystemTime(uuid, systemTime);
		return Response.ok().build();
	}
	
}




/******* S.D.G. *******/


