/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.card.models.CardModel;
import com.anfelisa.card.models.ChangeCardOrderListModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ChangeOrderCommand extends AbstractChangeOrderCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeOrderCommand.class);

	public ChangeOrderCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<ChangeCardOrderListModel> executeCommand(Data<ChangeCardOrderListModel> data, PersistenceHandle readonlyHandle) {
		CardModel card1 = daoProvider.getCardDao().selectByCardId(readonlyHandle, data.getModel().getCardId());
		if (card1 == null) {
			throwIllegalArgumentException("cardDoesNotExist");
		}
		UserAccessToCategoryModel accessToRootCategory = this.daoProvider.getUserAccessToCategoryDao()
				.hasUserAccessTo(readonlyHandle, card1.getRootCategoryId(), data.getModel().getUserId());
		if (accessToRootCategory == null || !accessToRootCategory.getEditable()) {
			throwSecurityException();
		}
		
		CardModel card2 = daoProvider.getCardDao().selectByCategoryIdAndIndex(readonlyHandle, card1.getCategoryId(), card1.getCardIndex() + (data.getModel().getDown() ? 1 : -1));
		if (card2 == null) {
			this.addNoMoveOutcome(data);
			return data;
		}
		
		int index1 = card1.getCardIndex();
		int index2 = card2.getCardIndex();

		card1.setCardIndex(index2);
		card2.setCardIndex(index1);

		data.getModel().setUpdatedCard1(card1);
		data.getModel().setUpdatedCard2(card2);
		this.addOkOutcome(data);
		return data;
	}

}




/******* S.D.G. *******/



