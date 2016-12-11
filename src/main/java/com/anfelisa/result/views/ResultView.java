package com.anfelisa.result.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.result.data.ResultCreationData;
import com.anfelisa.result.data.ResultSaveData;
import com.anfelisa.result.models.IResultModel;
import com.anfelisa.result.models.ResultDao;
import com.anfelisa.result.models.ResultModel;

public class ResultView {

	public BiConsumer<ResultCreationData, Handle> createResult = (dataContainer, handle) -> {
		ResultDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<ResultSaveData, Handle> saveResult = (dataContainer, handle) -> {
		IResultModel result = new ResultModel(null, dataContainer.getUsername(), dataContainer.getTestId(),
				dataContainer.getDate(), dataContainer.getJson(), dataContainer.getPoints(),
				dataContainer.getMaxPoints());
		ResultDao.insert(handle, result, dataContainer.getSchema());
	};

}

/* S.D.G. */
