package com.anfelisa.category.actions;

import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.ICategoryTreeRootItemModel;

public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(jdbi, appConfiguration, daoProvider, viewProvider, e2e);
	}

	protected final void loadDataForGetRequest(Handle readonlyHandle) {
		List<ICategoryTreeRootItemModel> rootCategories = daoProvider.getCategoryDao().selectAllRoot(readonlyHandle,
				actionData.getUserId());
		actionData.setCategoryList(rootCategories);
		for (ICategoryTreeRootItemModel categoryItemModel : rootCategories) {
			categoryItemModel.setChildCategories(loadChildren(categoryItemModel.getCategoryId(), readonlyHandle));
		}
	}

	private List<ICategoryTreeItemModel> loadChildren(String categoryId, Handle readonlyHandle) {
		List<ICategoryTreeItemModel> children = daoProvider.getCategoryDao().selectAllChildren(readonlyHandle, categoryId,
				actionData.getUserId());
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
