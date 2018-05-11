package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.FillBoxData;

public class BoxView {

	// private DaoProvider daoProvider;

	public BoxView(DaoProvider daoProvider) {
		super();
		// this.daoProvider = daoProvider;
	}

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		// daoProvider.boxDao.insert(handle, dataContainer);
	};

	public BiConsumer<BoxCreationData, Handle> updateBox = (dataContainer, handle) -> {
		// daoProvider.customBoxDao.updateBox(handle, dataContainer);
	};

	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		// daoProvider.boxDao.deleteByBoxId(handle, dataContainer.getBoxId());
	};

	public BiConsumer<FillBoxData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		// List<IScheduledCardModel> cards = dataContainer.getCardsToBeAdded();
		// for (IScheduledCardModel card : cards) {
		// daoProvider.scheduledCardDao.insert(handle, card);
		// }
	};

}

/* S.D.G. */
