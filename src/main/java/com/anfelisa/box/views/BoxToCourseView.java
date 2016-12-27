package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxConfigData;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.IBoxOfCourseModel;

public class BoxToCourseView {

	public BiConsumer<BoxToCourseAdditionData, Handle> addCourseToBox = (dataContainer, handle) -> {
		BoxOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<BoxConfigData, Handle> saveBoxConfig = (dataContainer, handle) -> {
		List<IBoxOfCourseModel> list = dataContainer.getBoxOfCourseList();
		for (IBoxOfCourseModel item : list) {
			if (item.getAutoAdd() != null) {
				BoxOfCourseDao.insert(handle, item, dataContainer.getSchema());
			}
		}
	};
	
}

/*                    S.D.G.                    */
