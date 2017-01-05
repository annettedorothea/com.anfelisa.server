package com.anfelisa.result.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.result.data.ResultCreationData;
import com.anfelisa.result.data.ResultSaveData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.result.models.ResultModel;

public class ResultView {

	public BiConsumer<ResultCreationData, Handle> createResult = (dataContainer, handle) -> {
		Integer resultId = ResultDao.insert(handle, dataContainer, dataContainer.getSchema());
		dataContainer.setCreatedId("" + resultId);
	};

	public BiConsumer<ResultSaveData, Handle> saveResult = (dataContainer, handle) -> {
		IResultModel result = new ResultModel(null, dataContainer.getUsername(), dataContainer.getTestId(),
				dataContainer.getDate(), dataContainer.getJson(), dataContainer.getPoints(),
				dataContainer.getMaxPoints());
		Integer resultId = ResultDao.insert(handle, result, dataContainer.getSchema());
		dataContainer.setCreatedId("" + resultId);
	};

	public BiConsumer<ResultSaveData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		List<ICardOfBoxModel> cards = dataContainer.getCardsToBeAdded();
		for (ICardOfBoxModel card : cards) {
			CardOfBoxDao.insert(handle, card, dataContainer.getSchema());
		}
	};
	

}

/* S.D.G. */
