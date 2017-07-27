package com.anfelisa.test.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.test.data.CardContentHashListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCardsOfTestAction extends AbstractGetCardsOfTestAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsOfTestAction.class);

	private CustomCardDao customCardDao = new CustomCardDao();

	public GetCardsOfTestAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@GET
	@Timed
	@Path("/cards")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("testId") Integer testId) throws JsonProcessingException {
		this.actionData = new CardContentHashListData(uuid).withTestId(testId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<ICardModel> cards = customCardDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId());
		List<Integer> contentHashes = new ArrayList<Integer>();
		for (ICardModel card : cards) {
			contentHashes.add(Integer.parseInt(card.getContentHash()));
		}
		this.actionData.setContentHashList(contentHashes);
	}

}

/* S.D.G. */
