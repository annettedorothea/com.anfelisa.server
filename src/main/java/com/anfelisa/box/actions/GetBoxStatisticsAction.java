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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxStatisticsModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxStatisticsAction extends AbstractGetBoxStatisticsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxStatisticsAction.class);

	public GetBoxStatisticsAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}


	@Override
	protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		List<IBoxStatisticsModel> boxList = this.daoProvider.getBoxDao().selectStatisticsByUserId(readonlyHandle,
				this.actionData.getUserId());
		for (IBoxStatisticsModel box : boxList) {
			LocalDateTime day = actionData.getTodayAtMidnightInUTC();
			box.setCountsPerDayNextWeek(new ArrayList<>());
			for (int i = 0; i < 7; i++) {
				day = day.plusDays(1);
				Integer countOfDay = this.daoProvider.getBoxDao().selectCountOfDay(readonlyHandle, box.getBoxId(), day);
				box.getCountsPerDayNextWeek().add(countOfDay);
			}
		}
		this.actionData.setBoxStatisticsList(boxList);
	}
	
	public void initActionData() {
	}


}




/******* S.D.G. *******/



