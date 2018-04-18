package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.ReinforceCardListData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CardContentModel;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ILineModel;
import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.LineModel;
import com.anfelisa.box.models.ReinforceCardModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadReinforceCardListAction extends AbstractLoadReinforceCardListAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadReinforceCardListAction.class);

	private BoxDao boxDao = new BoxDao();

	private CustomScheduledCardDao scheduledCardDao = new CustomScheduledCardDao();

	private CardDao cardDao = new CardDao();

	public LoadReinforceCardListAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/reinforce")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") String boxId) throws JsonProcessingException {
		this.actionData = new ReinforceCardListData(uuid).withBoxId(boxId).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername()).withUsername(user.getUsername());
		return this.apply();
	}

	@SuppressWarnings("unchecked")
	protected final void loadDataForGetRequest() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), this.actionData.getBoxId());
		if (!box.getUsername().equals(actionData.getCredentialsUsername())) {
			throwUnauthorized();
		}

		this.actionData.setBoxName(box.getName());

		List<IScheduledCardModel> scheduledCards = scheduledCardDao
				.selectReinforceCards(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(), this.actionData.getSystemTime());
		List<IReinforceCardModel> reinforceCards = new ArrayList<>();
		for (IScheduledCardModel scheduledCard : scheduledCards) {
			ICardModel card = cardDao.selectByCardId(this.getHandle(), scheduledCard.getCardId());
			//String content = card.getContent();
			ObjectMapper mapper = new ObjectMapper();
			try {
				//Map<Object, Object> cardContentModel = mapper.readValue(content, Map.class);
				Map<Object, Object> cardContentModel = new HashMap<>();
				Boolean complex = (Boolean) cardContentModel.get("complex");
				String given = (String) cardContentModel.get("given");
				List<Map<Object, Object>> lineList = (List<Map<Object, Object>>) cardContentModel.get("lines");
				List<ILineModel> lines = new ArrayList<ILineModel>();
				if (lineList != null) {
					for (Map<Object, Object> line : lineList) {
						List<Map<Object, Object>> wordList = (List<Map<Object, Object>>) line.get("line");
						List<String> words = new ArrayList<String>();
						for (Map<Object, Object> wordMap : wordList) {
							String word = (String) wordMap.get("word");
							words.add(word);
						}
						lines.add(new LineModel(words));
					}
				}
				Boolean large = (Boolean) cardContentModel.get("large");
				String wanted = (String) cardContentModel.get("wanted");
				String header = (String) cardContentModel.get("header");
				CardContentModel cardContent = new CardContentModel(complex, given, large, wanted, header, lines);
				ReinforceCardModel reinforceCard = new ReinforceCardModel(scheduledCard.getScheduledCardId(),
						scheduledCard.getScheduledDate(), scheduledCard.getLastQuality(), scheduledCard.getTimestamp(), cardContent);
				reinforceCards.add(reinforceCard);
			} catch (Exception e) {
				e.printStackTrace();
				//throw new WebApplicationException("cannot parse " + content + ".");
				throw new WebApplicationException("cannot parse card.");
			}

			this.actionData.setList(reinforceCards);

		}
	}

}

/* S.D.G. */
