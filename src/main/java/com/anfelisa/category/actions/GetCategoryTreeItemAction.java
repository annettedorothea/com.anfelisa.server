package com.anfelisa.category.actions;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;


import com.anfelisa.category.data.CategoryTreeData;

@Path("/CategoryTree")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class GetCategoryTreeItemAction extends AbstractGetCategoryTreeItemAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeItemAction.class);

	public GetCategoryTreeItemAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/get")
	@PermitAll
	public Response get() throws JsonProcessingException {
		this.actionData = null;
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
	}

}

/*       S.D.G.       */
