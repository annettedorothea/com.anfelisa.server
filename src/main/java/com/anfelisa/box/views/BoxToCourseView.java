package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxConfigData;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.IBoxOfCourseModel;

public class BoxToCourseView {

	public BiConsumer<BoxToCourseAdditionData, Handle> addCourseToBox = (dataContainer, handle) -> {
		BoxOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<BoxConfigData, Handle> saveBoxConfig = (dataContainer, handle) -> {
		List<IBoxOfCourseModel> list = dataContainer.getBoxOfCourseList();
		List<IBoxOfCourseModel> existingItems = dataContainer.getExistingItems();
		for (int i=0; i<list.size(); i++) {
			IBoxOfCourseModel item = list.get(i);
			IBoxOfCourseModel existingItem  = existingItems.get(i);
			if (item.getAutoAdd() != null) {
				if (existingItem != null) {
					CustomBoxOfCourseDao.updateAutoAdd(handle, dataContainer.getSchema(), item);
				} else {
					BoxOfCourseDao.insert(handle, item, dataContainer.getSchema());
				}
			}
		}
	};

}

/* S.D.G. */
