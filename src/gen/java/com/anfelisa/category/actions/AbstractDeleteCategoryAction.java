package com.anfelisa.category.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.category.data.CategoryDeleteData;

import com.anfelisa.category.commands.DeleteCategoryCommand;

public abstract class AbstractDeleteCategoryAction extends Action<CategoryDeleteData> {

	public AbstractDeleteCategoryAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super("com.anfelisa.category.actions.DeleteCategoryAction", HttpMethod.DELETE, jdbi, appConfiguration, daoProvider);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteCategoryCommand(this.actionData, databaseHandle, daoProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CategoryDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
