package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.StudentToCourseAdditionData;

import com.anfelisa.course.commands.AddStudentToCourseCommand;

public abstract class AbstractAddStudentToCourseAction extends Action<StudentToCourseAdditionData> {

	public AbstractAddStudentToCourseAction(DBI jdbi) {
		super("com.anfelisa.course.actions.AddStudentToCourseAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new AddStudentToCourseCommand(this.actionData, databaseHandle);
	}

	protected final void loadDataForGetRequest() {
	}

	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, StudentToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
