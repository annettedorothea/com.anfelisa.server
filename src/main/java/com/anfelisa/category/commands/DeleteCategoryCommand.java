/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.models.CategoryDeleteModel;
import com.anfelisa.category.models.CategoryModel;
import com.anfelisa.category.models.UserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteCategoryCommand extends AbstractDeleteCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryCommand.class);

	public DeleteCategoryCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<CategoryDeleteModel> executeCommand(Data<CategoryDeleteModel> data, PersistenceHandle readonlyHandle) {
		CategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle,
				data.getModel().getCategoryId());
		if (category == null) {
			throwIllegalArgumentException("categoryDoesNotExist");
		}
		UserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, category.getRootCategoryId(), data.getModel().getUserId());
		if (access == null || !access.getEditable()) {
			throwSecurityException();
		}
		data.getModel().setCategoryIndex(category.getCategoryIndex());
		if (category.getParentCategoryId() == null) {
			throwIllegalArgumentException("rootCategoryMustNotBeDeleted");
		} else {
			data.getModel().setParentCategoryId(category.getParentCategoryId());
			this.addOkOutcome(data);
		}
		return data;
	}

}




/******* S.D.G. *******/



