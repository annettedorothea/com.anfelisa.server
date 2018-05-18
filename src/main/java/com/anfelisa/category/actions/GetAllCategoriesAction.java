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

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.data.CategoryListData;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class GetAllCategoriesAction extends AbstractGetAllCategoriesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllCategoriesAction.class);

	public GetAllCategoriesAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/all")
	@PermitAll
	public Response get(@Auth AuthUser user, @QueryParam("parentCategoryId") String parentCategoryId,
			@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CategoryListData(uuid).withParentCategoryId(parentCategoryId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		if (actionData.getParentCategoryId() != null) {
			List<ICategoryItemModel> categoryList = daoProvider.getCustomCategoryDao().selectAllChildren(getHandle(), actionData.getParentCategoryId());
			actionData.setCategoryList(categoryList);
			ICategoryModel parentCategory = daoProvider.getCategoryDao().selectByCategoryId(getHandle(), actionData.getParentCategoryId());
			List<ICardModel> cards = daoProvider.getCustomCardDao().selectAllOfCategory(getHandle(), actionData.getParentCategoryId());
			this.actionData.setCardList(cards);
			if (parentCategory != null) {
				this.actionData.setParentCategoryName(parentCategory.getCategoryName());
				this.actionData.setGrandParentCategoryId(parentCategory.getParentCategoryId());
				this.actionData.setParentDictionaryLookup(parentCategory.getDictionaryLookup());
				this.actionData.setParentGivenLanguage(parentCategory.getGivenLanguage());
				this.actionData.setParentWantedLanguage(parentCategory.getWantedLanguage());
			}
		} else {
			List<ICategoryItemModel> categoryList = daoProvider.getCustomCategoryDao().selectAllRoot(getHandle());
			actionData.setCategoryList(categoryList);
		}
	}

}

/*       S.D.G.       */
