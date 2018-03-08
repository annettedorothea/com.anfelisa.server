package com.anfelisa.box.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.box.data.BoxToCourseAdditionData;

import com.anfelisa.box.commands.AddCourseToBoxCommand;

public abstract class AbstractAddCourseToBoxAction extends Action<BoxToCourseAdditionData> {

	public AbstractAddCourseToBoxAction(DBI jdbi) {
		super("com.anfelisa.box.actions.AddCourseToBoxAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new AddCourseToBoxCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, BoxToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
