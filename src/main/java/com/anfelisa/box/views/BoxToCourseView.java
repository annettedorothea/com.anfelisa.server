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

	private BoxOfCourseDao boxOfCourseDao = new BoxOfCourseDao();

	private CustomBoxOfCourseDao customBoxOfCourseDao = new CustomBoxOfCourseDao();

	public BiConsumer<BoxToCourseAdditionData, Handle> addCourseToBox = (dataContainer, handle) -> {
		boxOfCourseDao.insert(handle, dataContainer);
	};

	public BiConsumer<BoxConfigData, Handle> saveBoxConfig = (dataContainer, handle) -> {
		List<IBoxOfCourseModel> list = dataContainer.getBoxOfCourseList();
		List<IBoxOfCourseModel> existingItems = dataContainer.getExistingItems();
		for (int i = 0; i < list.size(); i++) {
			IBoxOfCourseModel item = list.get(i);
			IBoxOfCourseModel existingItem = existingItems.get(i);
			if (item.getAutoAdd() != null) {
				if (existingItem != null) {
					customBoxOfCourseDao.updateAutoAdd(handle, item);
				} else {
					boxOfCourseDao.insert(handle, item);
				}
			}
		}
	};

}

/* S.D.G. */
