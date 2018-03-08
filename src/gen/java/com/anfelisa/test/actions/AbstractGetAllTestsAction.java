package com.anfelisa.test.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.test.data.SimpleTestListData;


public abstract class AbstractGetAllTestsAction extends Action<SimpleTestListData> {

	public AbstractGetAllTestsAction(DBI jdbi) {
		super("com.anfelisa.test.actions.GetAllTestsAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, SimpleTestListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
