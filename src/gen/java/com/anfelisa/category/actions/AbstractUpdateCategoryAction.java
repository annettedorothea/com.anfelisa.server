package com.anfelisa.category.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.category.data.CategoryUpdateData;

import com.anfelisa.category.commands.UpdateCategoryCommand;

public abstract class AbstractUpdateCategoryAction extends Action<CategoryUpdateData> {

	public AbstractUpdateCategoryAction(DBI jdbi) {
		super("com.anfelisa.category.actions.UpdateCategoryAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCategoryCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CategoryUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
