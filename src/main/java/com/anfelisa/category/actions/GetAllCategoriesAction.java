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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.category.data.CategoryListData;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.category.models.ICategoryModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class GetAllCategoriesAction extends AbstractGetAllCategoriesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllCategoriesAction.class);

	private CustomCategoryDao customCategoryDao = new CustomCategoryDao();
	
	private CategoryDao categoryDao = new CategoryDao();
	
	public GetAllCategoriesAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider, ViewProvider viewProvider) {
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
			List<ICategoryModel> categoryList = customCategoryDao.selectAllChildren(getHandle(), actionData.getParentCategoryId());
			actionData.setCategoryList(categoryList);
			ICategoryModel parentCategory = categoryDao.selectByCategoryId(getHandle(), actionData.getParentCategoryId());
			if (parentCategory != null) {
				this.actionData.setParentCategoryName(parentCategory.getCategoryName());
				this.actionData.setGrandParentCategoryId(parentCategory.getParentCategoryId());
			}
		} else {
			List<ICategoryModel> categoryList = customCategoryDao.selectAllRoot(getHandle());
			actionData.setCategoryList(categoryList);
		}
	}

}

/*       S.D.G.       */
