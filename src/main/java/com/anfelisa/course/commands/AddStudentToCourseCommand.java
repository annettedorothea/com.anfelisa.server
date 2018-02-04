package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.data.StudentToCourseAdditionData;

public class AddStudentToCourseCommand extends AbstractAddStudentToCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseCommand.class);

	public AddStudentToCourseCommand(StudentToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)
				&& !commandData.getUsername().equals(commandData.getCredentialsUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		this.commandData.setOutcome(added);
	}

}

/* S.D.G. */
