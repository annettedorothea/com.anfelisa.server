package com.anfelisa.category.actions;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.data.CategoryListData;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserWithAccessModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllCategoriesAction extends AbstractGetAllCategoriesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllCategoriesAction.class);

	public GetAllCategoriesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/all")
	@PermitAll
	public Response get(@Auth AuthUser user, @QueryParam("parentCategoryId") String parentCategoryId,
			@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CategoryListData(uuid).withParentCategoryId(parentCategoryId)
				.withUserId(user.getUserId());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		if (actionData.getParentCategoryId() != null) {
			List<ICategoryItemModel> categoryList = daoProvider.getCustomCategoryDao().selectAllChildren(getHandle(),
					actionData.getParentCategoryId(), actionData.getUserId());
			actionData.setCategoryList(categoryList);
			ICategoryModel parentCategory = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
					actionData.getParentCategoryId());
			List<ICardModel> cards = daoProvider.getCustomCardDao().selectAllOfCategory(getHandle(),
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
				IBoxModel box = daoProvider.getCustomBoxDao().selectByCategoryIdAndUserId(getHandle(),
						parentCategory.getRootCategoryId(), actionData.getUserId());
				this.actionData.setHasBox(box != null);
				List<IUserWithAccessModel> userAccessList = this.daoProvider.getCustomUserAccessToCategoryDao()
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
			List<ICategoryItemModel> categoryList = daoProvider.getCustomCategoryDao().selectAllRoot(getHandle(),
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

/* S.D.G. */
