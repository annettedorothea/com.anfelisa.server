/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.commands;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.InitBoxesModel;
import com.anfelisa.box.models.InitMyBoxesDataModel;
import com.anfelisa.box.models.PostponeCardsModel;
import com.anfelisa.box.models.ReinforceCardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class InitMyBoxesForDayCommand extends AbstractInitMyBoxesForDayCommand {

	static final Logger LOG = LoggerFactory.getLogger(InitMyBoxesForDayCommand.class);

	public InitMyBoxesForDayCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<InitMyBoxesDataModel>  executeCommand(Data<InitMyBoxesDataModel> data, PersistenceHandle readonlyHandle) {
		List<InitBoxesModel> boxList = this.daoProvider.getBoxDao().selectInitBoxesModelByUserId(readonlyHandle,
				data.getModel().getUserId(), data.getModel().getTodayAtMidnightInUTC());
		List<PostponeCardsModel> postponeCards = new ArrayList<PostponeCardsModel>();
		List<String> outdatedReinforceCardsIds = new ArrayList<String>();
		LocalDateTime today = data.getModel().getTodayAtMidnightInUTC();
		for (InitBoxesModel box : boxList) {
			List<ReinforceCardModel> outdatedReinforceCards = this.daoProvider.getReinforceCardDao()
					.selectOutdatedReinforceCards(readonlyHandle, box.getBoxId(), today);
			for (ReinforceCardModel card : outdatedReinforceCards) {
				outdatedReinforceCardsIds.add(card.getScheduledCardId());
			}
			LocalDateTime min = box.getMinScheduledDate();
			if (min != null) {
				if (min.isBefore(today)) {
					int days = (int) ChronoUnit.DAYS.between(min, today) + 1;
					PostponeCardsModel postponeData = new PostponeCardsModel(days, box.getBoxId());
					postponeCards.add(postponeData);
				}
			}
		}
		data.getModel().setPostponeCards(postponeCards);
		data.getModel().setOutdatedReinforceCardsIds(outdatedReinforceCardsIds);
		this.addOkOutcome(data);
		return data;
	}

}




/******* S.D.G. *******/



