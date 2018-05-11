package com.anfelisa.box.actions;

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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.AllBoxesData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllBoxesAction extends AbstractGetAllBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllBoxesAction.class);

	private BoxDao boxDao = new BoxDao();

	public GetAllBoxesAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/all")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response get(@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new AllBoxesData(uuid);
		return this.apply();
	}

	@Override
	protected void loadDataForGetRequest() {
		List<IBoxModel> allBoxes = boxDao.selectAll(this.getDatabaseHandle().getHandle());
		this.actionData.setBoxList(allBoxes);
	}

}

/* S.D.G. */
