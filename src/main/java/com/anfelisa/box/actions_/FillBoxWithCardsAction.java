package com.anfelisa.box.actions_;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.actions.AbstractFillBoxWithCardsAction;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.CardOfBoxModel;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;

public class FillBoxWithCardsAction extends AbstractFillBoxWithCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsAction.class);

	public FillBoxWithCardsAction(FillBoxData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		this.actionParam.setNow(new DateTime());
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		if (this.actionData.getCardsToBeAdded() == null) {
			this.actionData.setCardsToBeAdded(new ArrayList<>());
		}
		List<IBoxOfCourseModel> boxOfCourseList = new ArrayList<IBoxOfCourseModel>();
		List<IBoxOfCourseModel> boxOfCourses = CustomBoxOfCourseDao.selectByBoxId(this.getDatabaseHandle().getHandle(),
				this.actionData.getSchema(), this.actionData.getBoxId());
		boxOfCourseList.addAll(boxOfCourses);
		for (IBoxOfCourseModel boxOfCourse : boxOfCourseList) {
			List<ICardModel> allCards;
			if (boxOfCourse.getAutoAdd()) {
				allCards = CustomCardDao.selectCardsOfCourseThatAreNotAlreadyInBox(this.getDatabaseHandle().getHandle(),
						this.actionData.getSchema(), boxOfCourse.getCourseId(), boxOfCourse.getBoxId());
			} else {
				allCards = CustomCardDao.selectCardsOfCourseThatAreNotAlreadyInBoxAndHaveResult(
						this.getDatabaseHandle().getHandle(), this.actionData.getSchema(), boxOfCourse.getCourseId(),
						boxOfCourse.getBoxId(), this.actionData.getUsername());
			}
			for (ICardModel card : allCards) {
				ICardOfBoxModel cardOfBox = new CardOfBoxModel(null, card.getCardId(), 0F, 0, 0, 0, this.actionData.getNow(),
						boxOfCourse.getBoxId(), null, this.actionData.getNow(), 0);
				this.actionData.getCardsToBeAdded().add(cardOfBox);
			}
		}
	}

}

/* S.D.G. */
