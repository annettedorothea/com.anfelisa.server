package com.anfelisa.box.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.data.DeleteBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;

public class BoxView {

	public BiConsumer<BoxCreationData, Handle> createBox = (dataContainer, handle) -> {
		// update view
		BoxDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<BoxCreationData, Handle> updateBox = (dataContainer, handle) -> {
		// update view
		CustomBoxDao.updateBox(handle, dataContainer, dataContainer.getSchema());
	};
	
	public BiConsumer<DeleteBoxData, Handle> deleteBox = (dataContainer, handle) -> {
		// update view
		BoxDao.deleteByBoxId(handle, dataContainer.getBoxId(), dataContainer.getSchema());
	};
	
}

/*                    S.D.G.                    */
