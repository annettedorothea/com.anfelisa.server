package com.anfelisa.box.actions;

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

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.CategoryListData;
import com.anfelisa.box.models.CategorySelectionItemModel;
import com.anfelisa.box.models.ICategorySelectionItemModel;
import com.anfelisa.category.models.ICategoryItemModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetRootCategoriesAction extends AbstractGetRootCategoriesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetRootCategoriesAction.class);

	public GetRootCategoriesAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/root")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CategoryListData(uuid).withUserId(user.getUserId());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<ICategoryItemModel> rootCategories = this.daoProvider.getCustomCategoryDao()
				.selectAllRootWithoutMyBoxes(this.getHandle(), actionData.getUserId());
		List<ICategorySelectionItemModel> categoryList = new ArrayList<ICategorySelectionItemModel>();
		for (ICategoryItemModel categoryItemModel : rootCategories) {
			categoryList.add(new CategorySelectionItemModel(categoryItemModel.getCategoryId(),
					categoryItemModel.getCategoryName(), categoryItemModel.getCategoryIndex()));
		}
		this.actionData.setCategoryList(categoryList);
	}

}

/* S.D.G. */
