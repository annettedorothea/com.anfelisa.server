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




package com.anfelisa.box.actions;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

import de.acegen.auth.AuthUser;

import com.anfelisa.box.data.IBoxStatisticsListData;
import com.anfelisa.box.data.BoxStatisticsListData;

@SuppressWarnings("unused")
public abstract class AbstractGetBoxStatisticsAction extends ReadAction<IBoxStatisticsListData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxStatisticsAction.class);
	
	public AbstractGetBoxStatisticsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.box.actions.GetBoxStatisticsAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);

	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IBoxStatisticsListData originalActionData = (IBoxStatisticsListData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
	}
	
	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		DateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		} else {
			this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
		}
	}

}




/******* S.D.G. *******/



