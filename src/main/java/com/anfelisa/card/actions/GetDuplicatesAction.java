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

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.data.CardSearchData;
import com.anfelisa.card.models.ICardModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetDuplicatesAction extends AbstractGetDuplicatesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetDuplicatesAction.class);

	public GetDuplicatesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/search")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("given") String given,
			@NotNull @QueryParam("wanted") String wanted,
			@NotNull @QueryParam("naturalInputOrder") Boolean naturalInputOrder,
			@NotNull @QueryParam("categoryId") String categoryId, @NotNull @QueryParam("uuid") String uuid)
			throws JsonProcessingException {
		this.actionData = new CardSearchData(uuid).withCategoryId(categoryId).withGiven(given).withWanted(wanted)
				.withNaturalInputOrder(naturalInputOrder);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<ICardModel> cardList = this.daoProvider.getCustomCardDao().search(getHandle(), actionData.getCategoryId(),
				actionData.getNaturalInputOrder(), actionData.getGiven(), actionData.getWanted());
		this.actionData.setCardList(cardList);
	}

}

/* S.D.G. */
