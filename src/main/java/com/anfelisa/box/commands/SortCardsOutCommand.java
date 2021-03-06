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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ISortCardsOutData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.card.models.ICardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class SortCardsOutCommand extends AbstractSortCardsOutCommand {

	static final Logger LOG = LoggerFactory.getLogger(SortCardsOutCommand.class);

	public SortCardsOutCommand(ISortCardsOutData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (commandData.getCardIds() == null || commandData.getCardIds().isEmpty()) {
			this.addNullOrEmptyOutcome();
		} else {
			this.commandData.setSortedOutScheduledCardIds(new ArrayList<String>());
			this.commandData.setSortedOutReinforceCardIds(new ArrayList<String>());
			IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, commandData.getBoxId());
			if (box == null) {
				throwIllegalArgumentException("boxDoesNotExist");
			}
			if (!box.getUserId().equals(commandData.getUserId())) {
				throwSecurityException();
			}
			for (String cardId : commandData.getCardIds()) {
				ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle, cardId);
				if (card == null) {
					throwIllegalArgumentException("cardDoesNotExist");
				}
				IScheduledCardModel scheduledCard = daoProvider.getScheduledCardDao()
						.selectUnscoredByCardIdAndBoxId(readonlyHandle, cardId, box.getBoxId());
				if (scheduledCard != null) {
					this.commandData.getSortedOutScheduledCardIds().add(scheduledCard.getScheduledCardId());
					List<IReinforceCardModel> allOfCard = daoProvider.getReinforceCardDao()
							.selectAllOfCard(readonlyHandle, cardId);
					for (IReinforceCardModel reinforceCard : allOfCard) {
						this.commandData.getSortedOutReinforceCardIds().add(reinforceCard.getReinforceCardId());
					}
				}
			}
			this.addOkOutcome();
		}
	}

}

/******* S.D.G. *******/
