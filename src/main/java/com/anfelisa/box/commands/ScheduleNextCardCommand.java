package com.anfelisa.box.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScheduleNextCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.ICategoryModel;

public class ScheduleNextCardCommand extends AbstractScheduleNextCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleNextCardCommand.class);

	public ScheduleNextCardCommand(ScheduleNextCardData commandData, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), commandData.getBoxId());
		if (box == null) {
			throwBadRequest("boxDoesNotExist");
		}
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(), box.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		String nextCardId = searchNextCard(category);
		if (nextCardId == null) {
			throwBadRequest("noCardsLeft");
		} else {
			commandData.setCardId(nextCardId);
			commandData.setCount(0);
			commandData.setCreatedDate(this.commandData.getSystemTime());
			commandData.setEf(2.5F);
			commandData.setInterval(1);
			commandData.setLastQuality(null);
			commandData.setN(1);
			commandData.setScheduledDate(commandData.getSystemTime());
			commandData.setScheduledCardId(commandData.getUuid());
			commandData.setOutcome(ok);
		}
	}

	private String searchNextCard(ICategoryModel category) {
		String nextCardId = daoProvider.getScheduledCardDao().selectNextCardId(getHandle(), category.getCategoryId(),
				commandData.getBoxId());
		if (nextCardId != null) {
			return nextCardId;
		}
		List<ICategoryModel> categories = daoProvider.getCategoryDao().selectAllChildren(getHandle(),
				category.getCategoryId());
		for (ICategoryModel subCategory : categories) {
			nextCardId = searchNextCard(subCategory);
			if (nextCardId != null) {
				return nextCardId;
			}
		}
		return null;
	}

}

/* S.D.G. */
