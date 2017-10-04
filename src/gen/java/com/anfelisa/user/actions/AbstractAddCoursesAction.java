package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.AddCoursesData;

import com.anfelisa.user.commands.AddCoursesCommand;

public abstract class AbstractAddCoursesAction extends Action<AddCoursesData> {

	public AbstractAddCoursesAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.user.actions.AddCoursesAction", HttpMethod.POST, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return new AddCoursesCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, AddCoursesData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
