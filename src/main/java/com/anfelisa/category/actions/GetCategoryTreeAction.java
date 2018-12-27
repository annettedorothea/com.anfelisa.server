package com.anfelisa.category.actions;

import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.models.CategoryTreeItemModel;
import com.anfelisa.category.models.CategoryTreeRootItemModel;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.ICategoryTreeRootItemModel;

public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		List<ICategoryItemModel> rootCategories = daoProvider.getCustomCategoryDao().selectAllRoot(getHandle(),
				actionData.getUserId());
		List<ICategoryTreeRootItemModel> categoryList = new ArrayList<ICategoryTreeRootItemModel>();
		actionData.setCategoryList(categoryList);
		for (ICategoryItemModel categoryItemModel : rootCategories) {
			ICategoryTreeRootItemModel rootItem = new CategoryTreeRootItemModel(categoryItemModel.getCategoryId(),
					categoryItemModel.getCategoryName(), categoryItemModel.getCategoryIndex(),
					categoryItemModel.getEmpty(), categoryItemModel.getEditable(), categoryItemModel.getHasBox(),
					loadChildren(categoryItemModel.getCategoryId()));
			categoryList.add(rootItem);
		}
	}

	private List<ICategoryTreeItemModel> loadChildren(String categoryId) {
		List<ICategoryTreeItemModel> categoryChildren = new ArrayList<ICategoryTreeItemModel>();
		List<ICategoryItemModel> children = daoProvider.getCustomCategoryDao().selectAllChildren(getHandle(),
				categoryId, actionData.getUserId());
		for (ICategoryItemModel child : children) {
			categoryChildren.add(
					new CategoryTreeItemModel(child.getCategoryId(), child.getCategoryName(), child.getCategoryIndex(),
							child.getEmpty(), child.getEditable(), loadChildren(child.getCategoryId())));
		}
		return categoryChildren;
	}

}

/*       S.D.G.       */
