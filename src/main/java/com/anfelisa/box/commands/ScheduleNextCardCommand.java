package com.anfelisa.box.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScheduleCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.ICategoryItemModel;

public class ScheduleNextCardCommand extends AbstractScheduleNextCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleNextCardCommand.class);

	public ScheduleNextCardCommand(ScheduleCardData commandData, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), commandData.getBoxId());
		if (box == null) {
			throwBadRequest("box does not exist");
		}
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		String nextCardId = searchNextCard(box.getCategoryId());
		if (nextCardId == null) {
			commandData.setOutcome(noCard);
		} else {
			commandData.setCardId(nextCardId);
			commandData.setCount(0);
			commandData.setCreatedDate(this.commandData.getSystemTime());
			commandData.setEf(2.5F);
			commandData.setInterval(1);
			commandData.setLastQuality(null);
			commandData.setN(1);
			commandData.setScheduledDate(commandData.getToday());
			commandData.setScheduledCardId(commandData.getUuid());
			commandData.setOutcome(ok);
		}
	}

	private String searchNextCard(String categoryId) {
		String nextCardId = daoProvider.getCustomScheduledCardDao().selectNextCardId(getHandle(), categoryId,
				commandData.getBoxId());
		if (nextCardId != null) {
			return nextCardId;
		}
		List<ICategoryItemModel> categories = daoProvider.getCustomCategoryDao().selectAllChildren(getHandle(),
				categoryId);
		for (ICategoryItemModel category : categories) {
			return searchNextCard(category.getCategoryId());
		}
		return null;
	}

}

/* S.D.G. */
