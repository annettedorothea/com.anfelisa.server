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

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReadAction<T extends IDataContainer> extends Action<T> {

	static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);
	
	private PersistenceConnection persistenceConnection;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	private E2E e2e;
	
	public ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(actionName, HttpMethod.GET);
		this.persistenceConnection = persistenceConnection;
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.e2e = e2e;
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
	
	protected abstract void initActionDataFrom(ITimelineItem timelineItem);

	protected abstract void initActionDataFromNotReplayableDataProvider();

	public Response apply() {
		DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
		databaseHandle.beginTransaction();
		try {
			if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
					|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())
					|| ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
					databaseHandle.rollbackTransaction();
					LOG.error("duplicate request {} {} ", actionName, this.actionData.getUuid());
					return Response.status(Response.Status.OK).entity("ignoring duplicate request " +  this.actionData.getUuid()).build();
				}
				this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
				this.initActionData();
			} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
				ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
				initActionDataFrom(timelineItem);
			}
			if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				initActionDataFromNotReplayableDataProvider();
			}
			this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
			
			if (appConfiguration.getServerConfiguration().writeTimeline()) {
				daoProvider.getAceDao().addActionToTimeline(this, databaseHandle.getTimelineHandle());
			}
			Response response = Response.ok(this.createReponse()).build();
			databaseHandle.commitTransaction();
			return response;
		} catch (WebApplicationException x) {
			LOG.error(actionName + " returns {} due to {} ", x.getResponse().getStatusInfo(), x.getMessage());
			try {
				databaseHandle.rollbackTransaction();
				if (appConfiguration.getServerConfiguration().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
				}
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
		} catch (Exception x) {
			LOG.error(actionName + " failed " + x.getMessage());
			x.printStackTrace();
			try {
				databaseHandle.rollbackTransaction();
				if (appConfiguration.getServerConfiguration().writeError()) {
					daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
				}
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
			}
			String message = x.getMessage();
			StackTraceElement[] stackTrace = x.getStackTrace();
			int i = 1;
			for (StackTraceElement stackTraceElement : stackTrace) {
				message += "\n" + stackTraceElement.toString();
				if (i > 3) {
					message += "\n" + (stackTrace.length - 4) + " more...";
					break;
				}
				i++;
			}
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
		} finally {
			databaseHandle.close();
		}
	}

}




/******* S.D.G. *******/



