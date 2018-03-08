package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;

import com.anfelisa.test.commands.UpdateTestCommand;

public abstract class AbstractUpdateTestAction extends Action<TestCreationData> {

	public AbstractUpdateTestAction(DBI jdbi) {
		super("com.anfelisa.test.actions.UpdateTestAction", HttpMethod.PUT, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateTestCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
