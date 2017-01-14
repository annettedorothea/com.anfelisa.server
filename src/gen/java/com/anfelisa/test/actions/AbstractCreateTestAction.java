package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.TestCreationData;

import com.anfelisa.test.commands.CreateTestCommand;

public abstract class AbstractCreateTestAction extends Action<TestCreationData> {

	public AbstractCreateTestAction(DBI jdbi) {
		super("CreateTestAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new CreateTestCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
