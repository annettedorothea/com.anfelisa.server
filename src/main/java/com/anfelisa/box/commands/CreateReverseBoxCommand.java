/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxCreationModel;
import com.anfelisa.box.models.BoxModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class CreateReverseBoxCommand extends AbstractCreateReverseBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateReverseBoxCommand.class);

	public CreateReverseBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<BoxCreationModel> executeCommand(Data<BoxCreationModel> data, PersistenceHandle readonlyHandle) {
		UserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, data.getModel().getRootCategoryId(), data.getModel().getUserId());
		if (access == null) {
			throwSecurityException();
		}
		BoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle, data.getModel().getRootCategoryId(), data.getModel().getUserId(), false);
		if (box == null) {
			throwIllegalArgumentException("boxNotFound");
		}

		BoxModel reverseBox = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle, data.getModel().getRootCategoryId(), data.getModel().getUserId(), true);
		if (reverseBox == null) {
			data.getModel().setCategoryId(box.getCategoryId());
			data.getModel().setMaxInterval(box.getMaxInterval());
			data.getModel().setMaxCardsPerDay(box.getMaxCardsPerDay());
			data.getModel().setReverse(true);
			data.getModel().setArchived(false);
			data.getModel().setEditable(false);
			data.getModel().setBoxId(data.getUuid());
			this.addOkOutcome(data);
		} else {
			this.addAlreadyExistsOutcome(data);
		}
		return data;
	}

}




/******* S.D.G. *******/



