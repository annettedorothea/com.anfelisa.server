package com.anfelisa.box.views;

import java.util.List;
import java.util.function.BiConsumer;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.box.data.BoxConfigData;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxOfCourseDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.CardOfBoxModel;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;

public class BoxToCourseView {

	public BiConsumer<BoxToCourseAdditionData, Handle> addCourseToBox = (dataContainer, handle) -> {
		BoxOfCourseDao.insert(handle, dataContainer, dataContainer.getSchema());
	};

	public BiConsumer<BoxConfigData, Handle> saveBoxConfig = (dataContainer, handle) -> {
		List<IBoxOfCourseModel> list = dataContainer.getBoxOfCourseList();
		for (IBoxOfCourseModel item : list) {
			if (item.getAutoAdd() != null) {
				BoxOfCourseDao.insert(handle, item, dataContainer.getSchema());
				if (item.getAutoAdd()) {
					List<ICardModel> cards = CustomCardDao.selectCardsOfCourseThatAreNotAlreadyInBox(handle,
							dataContainer.getSchema(), item.getCourseId(), item.getBoxId());
					for (ICardModel card : cards) {
						ICardOfBoxModel cardOfBoxModel = new CardOfBoxModel(null, card.getCardId(), 0F, 0, 0,
								new DateTime(), item.getBoxId(), 0, new DateTime(), 0);
						CardOfBoxDao.insert(handle, cardOfBoxModel, dataContainer.getSchema());
					}
				}
			}
		}
	};

}

/* S.D.G. */
