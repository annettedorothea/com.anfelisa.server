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




package com.anfelisa.user.deleteuser.scenarios;

import java.util.List;

import javax.ws.rs.core.Response;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;

@SuppressWarnings("unused")
public class DeleteCascadesScenario extends AbstractDeleteCascadesScenario {

	@Override
	protected void verifications() {
		IUserModel user = this.daoProvider.getUserDao().selectByUsername(handle, "Annette-" + getTestId());
		assertIsNull(user);

		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(handle,"boxId-" + getTestId());
		assertIsNull(box);

		List<IUserAccessToCategoryModel> access = daoProvider.getUserAccessToCategoryDao().selectByUserId(handle, "uuid-" + getTestId());
		assertThat(access.size(), 0);
		
		List<String> allCategories = daoProvider.getCategoryDao().selectAllByRootCategoryId(handle,"boxId-" + getTestId());
		assertThat(allCategories.size(), 0);
		
		List<ICardModel> allCards = daoProvider.getCardDao().selectAllByRootCategoryId(handle,"boxId-" + getTestId());
		assertThat(allCards.size(), 0);
		
		List<IScheduledCardModel> allScheduledCards = daoProvider.getScheduledCardDao().selectAllCardsOfBox(handle,
				"boxId-" + getTestId());
		assertThat(allScheduledCards.size(), 0);

		List<IReinforceCardModel> allReinforceCards = daoProvider.getReinforceCardDao().selectAllOfBox(handle,"boxId-" + getTestId());
		assertThat(allReinforceCards.size(), 0);
		
		user = this.daoProvider.getUserDao().selectByUsername(handle, "Admin");
		assertIsNotNull(user);

		box = daoProvider.getBoxDao().selectByBoxId(handle, "adminBox");
		assertIsNotNull(box);
		
		access = daoProvider.getUserAccessToCategoryDao().selectByUserId(handle, "uuid-admin");
		assertThat(access.size(), 1);
		
		allCategories = daoProvider.getCategoryDao().selectAllByRootCategoryId(handle, "adminBox");
		assertThat(allCategories.size(), 2);
		
		allCards = daoProvider.getCardDao().selectAllByRootCategoryId(handle, "adminBox");
		assertThat(allCards.size(), 1);
		
		allScheduledCards = daoProvider.getScheduledCardDao().selectAllCardsOfBox(handle,
				"adminBox");
		assertThat(allScheduledCards.size(), 2);
		
		allReinforceCards = daoProvider.getReinforceCardDao().selectAllOfBox(handle, "adminBox");
		assertThat(allReinforceCards.size(), 1);
	}

}




/******* S.D.G. *******/



