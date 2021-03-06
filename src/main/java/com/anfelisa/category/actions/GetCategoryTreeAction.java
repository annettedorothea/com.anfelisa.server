package com.anfelisa.category.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, actionData.getRootCategoryId(), actionData.getUserId());
		if (access == null) {
			throwSecurityException();
		}
		ICategoryTreeItemModel rootCategory = daoProvider.getCategoryDao().selectRoot(readonlyHandle,
				actionData.getRootCategoryId(), actionData.getUserId(), actionData.getReverse());
		loadChildren(rootCategory, rootCategory.getCategoryId(), readonlyHandle);

		IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
				rootCategory.getCategoryId(), actionData.getUserId(), actionData.getReverse());
		if (box == null) {
			throwIllegalArgumentException("boxNotFound");
		}
		this.actionData.setBoxId(box.getBoxId());

		if (this.actionData.getFilterNonScheduled() != null && this.actionData.getFilterNonScheduled()) {
			initNonScheduledCount(rootCategory, box.getBoxId(), this.actionData.getPriority(), readonlyHandle);
		}
		actionData.setRootCategory(rootCategory);

		if (box.getReverse()) {
			this.actionData.setReverseBoxExists(true);
		} else {
			IBoxModel reverseBox = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
					rootCategory.getCategoryId(), actionData.getUserId(), true);
			this.actionData.setReverseBoxExists(reverseBox != null);
		}
	}

	private void loadChildren(ICategoryTreeItemModel categoryItemModel, String rootCategoryId,
			PersistenceHandle readonlyHandle) {
		List<ICategoryTreeItemModel> children = daoProvider.getCategoryDao().selectAllChildrenForTree(readonlyHandle,
				categoryItemModel.getCategoryId(), actionData.getUserId(), actionData.getReverse());
		categoryItemModel.setChildCategories(children);
		for (ICategoryTreeItemModel child : children) {
			loadChildren(child, rootCategoryId, readonlyHandle);
		}
	}

	private void initNonScheduledCount(ICategoryTreeItemModel categoryItemModel, String boxId, Integer priority,
			PersistenceHandle readonlyHandle) {
		Integer nonScheduledCardCount = daoProvider.getCardDao().selectNonScheduledCardCountOfCategory(readonlyHandle,
				categoryItemModel.getCategoryId(), boxId, priority);
		for (ICategoryTreeItemModel child : categoryItemModel.getChildCategories()) {
			initNonScheduledCount(child, boxId, priority, readonlyHandle);
			nonScheduledCardCount += child.getNonScheduledCount();
		}
		categoryItemModel.setNonScheduledCount(nonScheduledCardCount);
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
