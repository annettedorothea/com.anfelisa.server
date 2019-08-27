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

package com.anfelisa.card.commands;

import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.IChangeCardOrderListData;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

public class ChangeOrderCommand extends AbstractChangeOrderCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeOrderCommand.class);

	public ChangeOrderCommand(IChangeCardOrderListData commandData, IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		ICardModel targetCard = daoProvider.getCardDao().selectByCardId(readonlyHandle, commandData.getCardId());
		if (targetCard == null) {
			throwBadRequest("cardDoesNotExist");
		}
		IUserAccessToCategoryModel accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, targetCard.getRootCategoryId(), commandData.getUserId());
		if (accessToRootCategory == null) {
			throwUnauthorized();
		}
		List<ICardModel> cards = daoProvider.getCardDao().selectAll(readonlyHandle, targetCard.getCategoryId());
		int index = 1;
		for (ICardModel card : cards) {
			if (card.getCardIndex() < targetCard.getCardIndex()) {
				if (!commandData.getCardIdList().contains(card.getCardId())) {
					card.setCardIndex(index);
					index++;
				}
			} else {
				break;
			}
		}
		List<ICardModel> movedCards = orderedMovedCards(cards);
		for (ICardModel card : movedCards) {
			card.setCardIndex(index);
			index++;
		}
		for (ICardModel card : cards) {
			if (card.getCardIndex() >= targetCard.getCardIndex()) {
				if (!commandData.getCardIdList().contains(card.getCardId())) {
					card.setCardIndex(index);
					index++;
				}
			}
		}
		this.commandData.setUpdatedIndices(cards);
		this.commandData.setOutcome(ok);

	}

	private List<ICardModel> orderedMovedCards(List<ICardModel> cards) {
		List<ICardModel> movedCards = new ArrayList<ICardModel>();
		for (ICardModel card : cards) {
			if (this.commandData.getCardIdList().contains(card.getCardId())) {
				movedCards.add(card);
			}
		}
		return movedCards;
	}

}

/******* S.D.G. *******/
