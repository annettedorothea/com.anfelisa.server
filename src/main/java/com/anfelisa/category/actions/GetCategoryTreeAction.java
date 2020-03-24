package com.anfelisa.category.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao()
				.selectByCategoryIdAndUserId(readonlyHandle, actionData.getRootCategoryId(), actionData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		ICategoryTreeItemModel rootCategory = daoProvider.getCategoryDao().selectRoot(readonlyHandle,
				actionData.getRootCategoryId());
		List<ICategoryTreeItemModel> childCategories = daoProvider.getCategoryDao().selectAllChildrenForTree(readonlyHandle,
				actionData.getRootCategoryId());
		rootCategory.setChildCategories(childCategories);
		for (ICategoryTreeItemModel categoryItemModel : childCategories) {
			categoryItemModel.setChildCategories(loadChildren(categoryItemModel.getCategoryId(), readonlyHandle));
		}
		actionData.setRootCategory(rootCategory);
	}

	private List<ICategoryTreeItemModel> loadChildren(String categoryId, PersistenceHandle readonlyHandle) {
		List<ICategoryTreeItemModel> children = daoProvider.getCategoryDao().selectAllChildrenForTree(readonlyHandle,
				categoryId);
		for (ICategoryTreeItemModel child : children) {
			child.setChildCategories(loadChildren(child.getCategoryId(), readonlyHandle));
		}
		return children;
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
