package com.anfelisa.card.actions;

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
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.data.CardListData;
import com.anfelisa.card.model.CustomCardDao;
import com.anfelisa.card.models.ICardModel;
import com.anfelisa.category.models.CategoryDao;
import com.anfelisa.category.models.ICategoryModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/card")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllCardsAction extends AbstractGetAllCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllCardsAction.class);

	private CustomCardDao customCardDao = new CustomCardDao();

	private CategoryDao categoryDao = new CategoryDao();

	public GetAllCardsAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super(jdbi, appConfiguration, daoProvider);
	}

	@GET
	@Timed
	@Path("/all")
	@PermitAll
	public Response get(@Auth AuthUser user, @QueryParam("categoryId") String categoryId,
			@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CardListData(uuid).withCategoryId(categoryId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ICategoryModel category = categoryDao.selectByCategoryId(getHandle(), actionData.getCategoryId());
		if (category == null) {
			this.throwBadRequest("category does not exist");
		}
		this.actionData.setCategoryName(category.getCategoryName());
		List<ICardModel> cards = customCardDao.selectAllOfCategory(getHandle(), actionData.getCategoryId());
		this.actionData.setCardList(cards);
	}

}

/* S.D.G. */
