package com.anfelisa.category.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.category.data.CategoryCreationData;

import com.anfelisa.category.commands.CreateCategoryCommand;

public abstract class AbstractCreateCategoryAction extends Action<CategoryCreationData> {

	public AbstractCreateCategoryAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.category.actions.CreateCategoryAction", HttpMethod.POST, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCategoryCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CategoryCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
