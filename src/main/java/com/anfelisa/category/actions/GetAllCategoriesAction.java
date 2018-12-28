package com.anfelisa.category.actions;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserWithAccessModel;

public class GetAllCategoriesAction extends AbstractGetAllCategoriesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllCategoriesAction.class);

	public GetAllCategoriesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}


	protected final void loadDataForGetRequest() {
		if (actionData.getParentCategoryId() != null) {
			List<ICategoryItemModel> categoryList = daoProvider.getCategoryDao().selectAllChildren(getHandle(),
					actionData.getParentCategoryId(), actionData.getUserId());
			actionData.setCategoryList(categoryList);
			ICategoryModel parentCategory = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
					actionData.getParentCategoryId());
			List<ICardModel> cards = daoProvider.getCardDao().selectAllOfCategory(getHandle(),
					actionData.getParentCategoryId());
			this.actionData.setCardList(cards);
			if (parentCategory != null) {
				this.actionData.setParentCategoryName(parentCategory.getCategoryName());
				this.actionData.setGrandParentCategoryId(parentCategory.getParentCategoryId());
				this.actionData.setParentDictionaryLookup(parentCategory.getDictionaryLookup());
				this.actionData.setParentGivenLanguage(parentCategory.getGivenLanguage());
				this.actionData.setParentWantedLanguage(parentCategory.getWantedLanguage());
				ICategoryModel rootCategory = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
						parentCategory.getRootCategoryId());
				this.actionData.setRootDictionaryLookup(rootCategory.getDictionaryLookup());
				IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(getHandle(),
						parentCategory.getRootCategoryId(), actionData.getUserId());
				this.actionData.setHasBox(box != null);
				List<IUserWithAccessModel> userAccessList = this.daoProvider.getUserAccessToCategoryDao()
						.selectByCategoryId(getHandle(), parentCategory.getRootCategoryId());
				if (containsUser(userAccessList, actionData.getUserId())) {
					this.actionData.setParentEditable(true);
				} else {
					this.actionData.setParentEditable(false);
				}
				this.actionData.setUserList(userAccessList);
			} else {
				throwBadRequest("category not found");
			}
		} else {
			List<ICategoryItemModel> categoryList = daoProvider.getCategoryDao().selectAllRoot(getHandle(),
					actionData.getUserId());
			actionData.setCategoryList(categoryList);
			this.actionData.setRootDictionaryLookup(true);
			this.actionData.setParentEditable(false);
		}
	}

	private boolean containsUser(List<IUserWithAccessModel> userAccessList, String userId) {
		for (IUserWithAccessModel userAccess : userAccessList) {
			if (userAccess.getUserId().equals(userId)) {
				return true;
			}
		}
		return false;
	}

}

/*       S.D.G.       */
