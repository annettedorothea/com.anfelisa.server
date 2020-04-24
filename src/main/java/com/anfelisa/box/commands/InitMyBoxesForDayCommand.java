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

package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.PostponeCardsData;
import com.anfelisa.box.models.IInitBoxesModel;
import com.anfelisa.box.models.IPostponeCardsModel;
import com.anfelisa.box.models.IReinforceCardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class InitMyBoxesForDayCommand extends AbstractInitMyBoxesForDayCommand {

	static final Logger LOG = LoggerFactory.getLogger(InitMyBoxesForDayCommand.class);

	public InitMyBoxesForDayCommand(IInitMyBoxesDataData commandData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		List<IInitBoxesModel> boxList = this.daoProvider.getBoxDao().selectInitBoxesModelByUserId(readonlyHandle,
				this.commandData.getUserId(), commandData.getToday());
		List<IPostponeCardsModel> postponeCards = new ArrayList<IPostponeCardsModel>();
		List<String> outdatedReinforceCardsIds = new ArrayList<String>();
		for (IInitBoxesModel box : boxList) {
			List<IReinforceCardModel> outdatedReinforceCards = this.daoProvider.getReinforceCardDao()
					.selectOutdatedReinforceCards(readonlyHandle, box.getBoxId(), commandData.getToday());
			for (IReinforceCardModel card : outdatedReinforceCards) {
				outdatedReinforceCardsIds.add(card.getScheduledCardId());
			}
			DateTime min = box.getMinScheduledDate();
			DateTime today = this.commandData.getToday();
			DateTime minDate = new DateTime(min.getYear(), min.getMonthOfYear(), min.getDayOfMonth(), 0, 0);
			DateTime minToday = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0);
			if (minDate != null && minDate.isBefore(minToday)) {
				int days = Days.daysBetween(minDate, minToday).getDays();
				PostponeCardsData postponeData = new PostponeCardsData(days, box.getBoxId(),
						commandData.getUuid());
				postponeCards.add(postponeData);
			}
		}
		this.commandData.setPostponeCards(postponeCards);
		this.commandData.setOutdatedReinforceCardsIds(outdatedReinforceCardsIds);
		this.commandData.setOutcome(ok);
	}

}

/******* S.D.G. *******/
