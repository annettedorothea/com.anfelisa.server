package com.anfelisa.result.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.result.data.ResultCreationData;
import com.anfelisa.result.models.ResultDao;

public class ResultView {

	public BiConsumer<ResultCreationData, Handle> createResult = (dataContainer, handle) -> {
		ResultDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

}

/*                    S.D.G.                    */
