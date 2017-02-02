package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;

public class FillBoxWithCardsCommand extends AbstractFillBoxWithCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsCommand.class);

	private BoxDao boxDao = new BoxDao();

	private CustomCardDao customCardDao = new CustomCardDao();

	private CustomBoxOfCourseDao customBoxOfCourseDao = new CustomBoxOfCourseDao();

	public FillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)) {
			IBoxModel box = boxDao.selectByBoxId(this.getHandle(), commandData.getBoxId(), commandData.getSchema());
			if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
				throwUnauthorized();
			}
		}
		this.commandData.setCardsToBeAdded(new ArrayList<>());
		List<IBoxOfCourseModel> boxOfCourseList = new ArrayList<IBoxOfCourseModel>();
		List<IBoxOfCourseModel> boxOfCourses = customBoxOfCourseDao.selectByBoxId(this.getDatabaseHandle().getHandle(),
				this.commandData.getSchema(), this.commandData.getBoxId());
		boxOfCourseList.addAll(boxOfCourses);
		for (IBoxOfCourseModel boxOfCourse : boxOfCourseList) {
			List<ICardModel> allCards;
			if (boxOfCourse.getAutoAdd()) {
				allCards = customCardDao.selectCardsOfCourseThatAreNotAlreadyInBox(this.getDatabaseHandle().getHandle(),
						this.commandData.getSchema(), boxOfCourse.getCourseId(), boxOfCourse.getBoxId());
			} else {
				allCards = customCardDao.selectCardsOfCourseThatAreNotAlreadyInBoxAndHaveResult(
						this.getDatabaseHandle().getHandle(), this.commandData.getSchema(), boxOfCourse.getCourseId(),
						boxOfCourse.getBoxId(), this.commandData.getCredentialsUsername());
			}
			for (ICardModel card : allCards) {
				IScheduledCardModel scheduledCard = new ScheduledCardModel(null, card.getCardId(), 2.5F, 0, 0, 0,
						this.commandData.getNow(), boxOfCourse.getBoxId(), null, this.commandData.getNow());
				this.commandData.getCardsToBeAdded().add(scheduledCard);
			}
		}
		this.outcome = fillBoxWithCards;
	}

}

/* S.D.G. */
