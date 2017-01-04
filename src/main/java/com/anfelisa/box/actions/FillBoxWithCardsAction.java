package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxIdListData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CardOfBoxModel;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;

public class FillBoxWithCardsAction extends AbstractFillBoxWithCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsAction.class);

	public FillBoxWithCardsAction(BoxIdListData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system
		// time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		if (this.actionData.getCardsToBeAdded() == null) {
			this.actionData.setCardsToBeAdded(new ArrayList<>());
		}
		if (this.actionData.getBoxNames() == null) {
			this.actionData.setBoxNames(new ArrayList<>());
		}
		if (this.actionData.getNumberOfInsertedCards() == null) {
			this.actionData.setNumberOfInsertedCards(new ArrayList<>());
		}
		List<IBoxOfCourseModel> boxOfCourseList = new ArrayList<IBoxOfCourseModel>();
		if (this.actionData.getBoxIds().size() == 0) {
			List<IBoxModel> allBoxes = BoxDao.selectAll(this.getDatabaseHandle().getHandle(),
					this.actionData.getSchema());
			for (IBoxModel box : allBoxes) {
				this.actionData.getBoxNames().add(box.getName());
				this.actionData.getBoxIds().add(box.getBoxId());
				List<IBoxOfCourseModel> boxOfCourses = CustomBoxOfCourseDao.selectByBoxId(
						this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), box.getBoxId());
				boxOfCourseList.addAll(boxOfCourses);
			}
		} else {
			for (Integer boxId : this.actionData.getBoxIds()) {
				IBoxModel box = BoxDao.selectByBoxId(this.getDatabaseHandle().getHandle(), boxId, this.actionData.getSchema());
				this.actionData.getBoxNames().add(box.getName());
				List<IBoxOfCourseModel> boxOfCourses = CustomBoxOfCourseDao
						.selectByBoxId(this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), boxId);
				boxOfCourseList.addAll(boxOfCourses);
			}
		}
		for (IBoxOfCourseModel boxOfCourse : boxOfCourseList) {
			List<ICardModel> allCards;
			if (boxOfCourse.getAutoAdd()) {
				allCards = CustomCardDao.selectCardsOfCourseThatAreNotAlreadyInBox(this.getDatabaseHandle().getHandle(),
						this.actionData.getSchema(), boxOfCourse.getCourseId(), boxOfCourse.getBoxId());
			} else {
				allCards = CustomCardDao.selectCardsOfCourseThatAreNotAlreadyInBoxAndHaveResult(
						this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), boxOfCourse.getCourseId(),
						boxOfCourse.getBoxId());
			}
			for (ICardModel card : allCards) {
				ICardOfBoxModel cardOfBox = new CardOfBoxModel(null, card.getCardId(), 0F, 0, 0, 0, new DateTime(),
						boxOfCourse.getBoxId(), 0, new DateTime(), 0);
				this.actionData.getCardsToBeAdded().add(cardOfBox);
			}
		}
		for (Integer boxId : this.actionData.getBoxIds()) {
			int numberOfCards = this.getNumberOfCardsWithBoxId(boxId);
			this.actionData.getNumberOfInsertedCards().add(numberOfCards);
		}
	}
	
	private int getNumberOfCardsWithBoxId(Integer boxId) {
		int i = 0;
		for (ICardOfBoxModel card : this.actionData.getCardsToBeAdded()) {
			if (card.getBoxId() == boxId) {
				i++;
			}
		}
		return i;
	}
}

/* S.D.G. */
