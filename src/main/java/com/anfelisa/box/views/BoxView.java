package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.ICardOfBoxModel;

public class BoxView {

	private BoxDao boxDao = new BoxDao();

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	private CardOfBoxDao cardOfBoxDao = new CardOfBoxDao();

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		Integer id = boxDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + id);
	};

	public BiConsumer<BoxCreationData, Handle> updateBox = (dataContainer, handle) -> {
		customBoxDao.updateBox(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		boxDao.deleteByBoxId(handle, dataContainer.getBoxId(), dataContainer.getSchema());
	};

	public BiConsumer<FillBoxData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		List<ICardOfBoxModel> cards = dataContainer.getCardsToBeAdded();
		for (ICardOfBoxModel card : cards) {
			cardOfBoxDao.insert(handle, card, dataContainer.getSchema());
		}
		dataContainer.setCreatedId(dataContainer.getCardsToBeAdded().size() + "");
	};

}

/* S.D.G. */
