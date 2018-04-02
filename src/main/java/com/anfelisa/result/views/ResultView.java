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
		resultDao.insert(handle, dataContainer);
	};

	public static BiConsumer<ResultSaveData, Handle> saveResult = (dataContainer, handle) -> {
		IResultModel result = new ResultModel(dataContainer.getResultId(), dataContainer.getUsername(), dataContainer.getTestId(),
				dataContainer.getDate(), dataContainer.getJson(), dataContainer.getPoints(),
				dataContainer.getMaxPoints());
		resultDao.insert(handle, result);
	};

	public static BiConsumer<ResultSaveData, Handle> fillBoxWithCards = (dataContainer, handle) -> {
		List<IScheduledCardModel> cards = dataContainer.getCardsToBeAdded();
		for (IScheduledCardModel card : cards) {
			scheduledCardDao.insert(handle, card);
		}
	};

}

/* S.D.G. */
