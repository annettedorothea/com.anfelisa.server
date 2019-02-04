package com.anfelisa.box.commands;

import org.jdbi.v3.core.Handle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.IPostponeCardsData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.INextCardViewModel;

public class PostponeCardsCommand extends AbstractPostponeCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(PostponeCardsCommand.class);

	public PostponeCardsCommand(IPostponeCardsData actionData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, this.commandData.getBoxId());
		if (!box.getUserId().equals(commandData.getUserId())) {
			throwUnauthorized();
		}
		DateTime todayDate = new DateTime(commandData.getToday());
		todayDate = todayDate.withZone(DateTimeZone.UTC);
		INextCardViewModel nextCard = daoProvider.getScheduledCardDao().selectFirstScheduledCard(readonlyHandle, 
				commandData.getBoxId(), todayDate);
		if (nextCard != null) {
			int days = Days.daysBetween(nextCard.getScheduledDate(), todayDate).getDays();
			if (days > 0) {
				this.commandData.setDays(days);
				this.commandData.setOutcome(ok);
			} else {
				this.commandData.setOutcome(noDelay);
			}
		} else {
			this.commandData.setOutcome(noDelay);
		}
	}

}

/*       S.D.G.       */
