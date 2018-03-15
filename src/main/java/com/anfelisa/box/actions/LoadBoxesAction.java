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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxListData;
import com.anfelisa.box.models.BoxInfoModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadBoxesAction extends AbstractLoadBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxesAction.class);

	private CustomScheduledCardDao customScheduledCardDao = new CustomScheduledCardDao();

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	public LoadBoxesAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new BoxListData(user.getUsername(), uuid);
		return this.apply();
	}

	@Override
	protected void loadDataForGetRequest() {
		List<IBoxModel> boxList = customBoxDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername());
		List<IBoxInfoModel> boxInfoList = new ArrayList<IBoxInfoModel>();
		for (IBoxModel boxModel : boxList) {
			List<IScheduledCardModel> todaysCards = customScheduledCardDao.selectTodaysCards(this.getHandle(),
					boxModel.getBoxId(), this.actionData.getSystemTime());
			BoxInfoModel boxInfoModel = new BoxInfoModel(todaysCards.size(), (todaysCards.size() > 0));
			boxInfoModel.setBox(boxModel);
			boxInfoList.add(boxInfoModel);
		}
		this.actionData.setBoxList(boxInfoList);
	}

}

/* S.D.G. */
