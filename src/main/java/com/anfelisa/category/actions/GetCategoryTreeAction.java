package com.anfelisa.category.actions;

import java.util.ArrayList;
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
import com.anfelisa.category.data.CategoryTreeData;
import com.anfelisa.category.models.CategoryTreeItemModel;
import com.anfelisa.category.models.CategoryTreeRootItemModel;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.ICategoryTreeItemModel;
import com.anfelisa.category.models.ICategoryTreeRootItemModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCategoryTreeAction extends AbstractGetCategoryTreeAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeAction.class);

	public GetCategoryTreeAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/tree")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CategoryTreeData(uuid).withUserId(user.getUserId()).withUserId(user.getUserId());
		return this.apply();
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

/* S.D.G. */
