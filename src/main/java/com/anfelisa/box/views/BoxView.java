package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.models.BoxDao;

public class BoxView {

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		// update view
		BoxDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

}

/*                    S.D.G.                    */
