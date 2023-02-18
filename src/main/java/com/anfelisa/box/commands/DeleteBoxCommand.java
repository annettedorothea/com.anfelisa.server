/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxModel;
import com.anfelisa.box.models.DeleteBoxModel;
import com.anfelisa.box.utils.Deletable;
import com.anfelisa.category.models.UserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteBoxCommand extends AbstractDeleteBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxCommand.class);

	public DeleteBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<DeleteBoxModel> executeCommand(Data<DeleteBoxModel> data, PersistenceHandle readonlyHandle) {
		BoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, data.getModel().getBoxId());
		if (box == null) {
			throwIllegalArgumentException("boxDoesNotExist");
		}
		if (!box.getUserId().equals(data.getModel().getUserId())) {
			throwSecurityException();
		}
		UserAccessToCategoryModel access = daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, box.getCategoryId(), data.getModel().getUserId());
		if (access == null) {
			throwSecurityException();
		}
		if (!box.getReverse()) {
			BoxModel reverseBox = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
					box.getCategoryId(), data.getModel().getUserId(), true);
			if (reverseBox != null) {
				data.getModel().setReverseBoxId(reverseBox.getBoxId());
				this.addDeleteReverseBoxOutcome(data);
			}
		}
		if (!Deletable.isBoxDeletable(daoProvider, readonlyHandle, box.getCategoryId(), box.getReverse(), data.getModel().getUserId())) {
			throwIllegalArgumentException("cannot delete shared box");
		}
		if (Deletable.onDeleteBoxDeleteCategory(daoProvider, readonlyHandle, box)) {
			this.addDeleteCategoryOutcome(data);
		} else if (!box.getReverse()) {
			this.addDeleteUserAccessToCategoryOutcome(data);
		}
		data.getModel().setRootCategoryId(box.getCategoryId());
		this.addDeleteBoxOutcome(data);
		return data;
	}

}

/******* S.D.G. *******/
