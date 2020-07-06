/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.2
 *
 */




package de.acegen.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.Config;
import de.acegen.CustomAppConfiguration;
import de.acegen.DatabaseHandle;
import de.acegen.E2E;
import de.acegen.EventFactory;
import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;

@Path("/e2e")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrepareE2EResource {

	private Jdbi jdbi;
	private CustomAppConfiguration configuration;

	static final Logger LOG = LoggerFactory.getLogger(PrepareE2EResource.class);

	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;
	private E2E e2e;

	public PrepareE2EResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, CustomAppConfiguration configuration) {
		super();
		this.jdbi = jdbi;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.e2e = e2e;
		this.configuration = configuration;
	}

	@PUT
	@Path("/prepare")
	public Response put(@NotNull @QueryParam("uuid") String uuid) {
		if (Config.LIVE.equals(configuration.getConfig().getMode())) {
			throw new WebApplicationException("prepare e2e replay is not available in a live environment", Response.Status.FORBIDDEN);
		}
		DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);
		LOG.info("PREPARE ACTION " + uuid);
		try {
			databaseHandle.beginTransaction();

			int eventCount = 0;
			ITimelineItem nextAction = e2e.selectNextAction();
			while (nextAction != null && !nextAction.getUuid().equals(uuid)) {
				ITimelineItem nextEvent = e2e.selectEvent(nextAction.getUuid());
				if (nextEvent != null) {
					LOG.info("PUBLISH EVENT " + nextEvent.getUuid() + " - " + nextEvent.getName());
					IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider, configuration);
					if (event != null) {
						event.notifyListeners(databaseHandle.getHandle());
						daoProvider.getAceDao().addPreparingEventToTimeline(event, nextAction.getUuid(), databaseHandle.getTimelineHandle());
						eventCount++;
					} else {
						LOG.error("failed to create " + nextEvent.getName());
					}
				}
				nextAction = e2e.selectNextAction();
			}

			databaseHandle.commitTransaction();
			return Response.ok("prepared action " + uuid + " by publishing " + eventCount + " events").build();
		} catch (Exception e) {
			databaseHandle.rollbackTransaction();
			LOG.error("exception during prepare action " + uuid);
			LOG.error(e.getMessage());
			throw new WebApplicationException(e);
		} finally {
			databaseHandle.close();
		}
	}

}



/******* S.D.G. *******/



