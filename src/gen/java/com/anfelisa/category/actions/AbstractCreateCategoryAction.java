package com.anfelisa.category.actions;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import io.dropwizard.auth.Auth;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IDataContainer;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.category.data.CategoryCreationData;

import com.anfelisa.category.commands.CreateCategoryCommand;

@SuppressWarnings("unused")
@Path("/category/create")
public abstract class AbstractCreateCategoryAction extends Action<CategoryCreationData> {

	public AbstractCreateCategoryAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.CreateCategoryAction", HttpMethod.POST, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCategoryCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (CategoryCreationData)data;
	}

	protected final void loadDataForGetRequest() {
	}

	@POST
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategoryResource(
			@Auth AuthUser authUser, 
			@NotNull CategoryCreationData payload)
			throws JsonProcessingException {
		this.actionData = new CategoryCreationData(payload.getUuid());
		this.actionData.setCategoryName(payload.getCategoryName());
		this.actionData.setParentCategoryId(payload.getParentCategoryId());
		this.actionData.setDictionaryLookup(payload.getDictionaryLookup());
		this.actionData.setGivenLanguage(payload.getGivenLanguage());
		this.actionData.setWantedLanguage(payload.getWantedLanguage());
		this.actionData.setUsername(authUser.getUsername());
		this.actionData.setUserId(authUser.getUserId());
		return this.apply();
	}

}

/*       S.D.G.       */
