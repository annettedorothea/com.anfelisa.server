package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardDao;

public class BoxView {

	private static BoxDao boxDao = new BoxDao();

	private static CustomBoxDao customBoxDao = new CustomBoxDao();

	private static ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	public static BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		boxDao.insert(handle, dataContainer);
	};

	public static BiConsumer<BoxCreationData, Handle> updateBox = (dataContainer, handle) -> {
		customBoxDao.updateBox(handle, dataContainer);
	};

	public static BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		boxDao.deleteByBoxId(handle, dataContainer.getBoxId());
	};

	public static BiConsumer<FillBoxData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		List<IScheduledCardModel> cards = dataContainer.getCardsToBeAdded();
		for (IScheduledCardModel card : cards) {
			scheduledCardDao.insert(handle, card);
		}
	};

}

/* S.D.G. */
