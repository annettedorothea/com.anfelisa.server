package com.anfelisa.category.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.category.data.CategoryMoveData;

import com.anfelisa.category.commands.MoveCategoryCommand;

public abstract class AbstractMoveCategoryAction extends Action<CategoryMoveData> {

	public AbstractMoveCategoryAction(DBI jdbi) {
		super("com.anfelisa.category.actions.MoveCategoryAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new MoveCategoryCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CategoryMoveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
