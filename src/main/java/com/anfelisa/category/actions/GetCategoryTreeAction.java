package com.anfelisa.category.actions;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.ICategoryTreeRootItemModel;

public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
		List<ICategoryTreeRootItemModel> rootCategories = daoProvider.getCategoryDao().selectAllRoot(getHandle(),
				actionData.getUserId());
		actionData.setCategoryList(rootCategories);
		for (ICategoryTreeRootItemModel categoryItemModel : rootCategories) {
			categoryItemModel.setChildCategories(loadChildren(categoryItemModel.getCategoryId()));
		}
	}

	private List<ICategoryTreeItemModel> loadChildren(String categoryId) {
		List<ICategoryTreeItemModel> children = daoProvider.getCategoryDao().selectAllChildren(getHandle(), categoryId,
				actionData.getUserId());
		for (ICategoryTreeItemModel child : children) {
			child.setChildCategories(loadChildren(child.getCategoryId()));
		}
		return children;
	}

}

/* S.D.G. */
