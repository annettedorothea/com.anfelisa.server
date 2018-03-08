package com.anfelisa.result.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.ResultSaveData;

import com.anfelisa.result.commands.SaveResultCommand;

public abstract class AbstractSaveResultAction extends Action<ResultSaveData> {

	public AbstractSaveResultAction(DBI jdbi) {
		super("com.anfelisa.result.actions.SaveResultAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new SaveResultCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, ResultSaveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
