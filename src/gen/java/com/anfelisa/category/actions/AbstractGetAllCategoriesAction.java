package com.anfelisa.category.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.category.data.CategoryListData;


public abstract class AbstractGetAllCategoriesAction extends Action<CategoryListData> {

	public AbstractGetAllCategoriesAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.actions.GetAllCategoriesAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CategoryListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
