package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.data.PostponeCardsData;

public class BoxView {

	private DaoProvider daoProvider;

	public BoxView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		daoProvider.getBoxDao().insert(handle, dataContainer);
	};

	public BiConsumer<BoxUpdateData, Handle> updateBox = (dataContainer, handle) -> {
		daoProvider.getCustomBoxDao().updateBox(handle, dataContainer);
	};

	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		daoProvider.getBoxDao().deleteByBoxId(handle, dataContainer.getBoxId());
	};
	
	
	public BiConsumer<PostponeCardsData, Handle> postponeCards = (dataContainer, handle) -> {
	};
	
	

	public BiConsumer<FillBoxData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		// List<IScheduledCardModel> cards = dataContainer.getCardsToBeAdded();
		// for (IScheduledCardModel card : cards) {
		// daoProvider.scheduledCardDao.insert(handle, card);
		// }
	};

}

/* S.D.G. */
