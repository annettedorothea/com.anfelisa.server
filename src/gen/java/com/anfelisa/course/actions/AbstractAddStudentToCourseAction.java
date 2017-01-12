package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.StudentToCourseAdditionData;

import com.anfelisa.course.commands.AddStudentToCourseCommand;

public abstract class AbstractAddStudentToCourseAction extends Action<StudentToCourseAdditionData> {

	public AbstractAddStudentToCourseAction(DBI jdbi) {
		super("AddStudentToCourseAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new AddStudentToCourseCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */
