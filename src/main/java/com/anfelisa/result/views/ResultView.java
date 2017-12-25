package com.anfelisa.result.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardDao;
import com.anfelisa.result.data.ResultCreationData;
import com.anfelisa.result.data.ResultSaveData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.result.models.ResultModel;

public class ResultView {

	private static ResultDao resultDao = new ResultDao();

	private static ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	public static BiConsumer<ResultCreationData, Handle> createResult = (dataContainer, handle) -> {
		Integer resultId = resultDao.insert(handle, dataContainer);
		dataContainer.setCreatedId("" + resultId);
	};

	public static BiConsumer<ResultSaveData, Handle> saveResult = (dataContainer, handle) -> {
		IResultModel result = new ResultModel(null, dataContainer.getUsername(), dataContainer.getTestId(),
				dataContainer.getDate(), dataContainer.getJson(), dataContainer.getPoints(),
				dataContainer.getMaxPoints());
		Integer resultId = resultDao.insert(handle, result);
		dataContainer.setCreatedId("" + resultId);
	};

	public static BiConsumer<ResultSaveData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		List<IScheduledCardModel> cards = dataContainer.getCardsToBeAdded();
		for (IScheduledCardModel card : cards) {
			scheduledCardDao.insert(handle, card);
		}
	};

}

/* S.D.G. */
