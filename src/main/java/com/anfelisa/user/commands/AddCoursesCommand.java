package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.user.data.AddCoursesData;
import com.anfelisa.user.models.UserDao;

public class AddCoursesCommand extends AbstractAddCoursesCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesCommand.class);

	private UserDao userDao = new UserDao();

	private CourseDao courseDao = new CourseDao();

	public AddCoursesCommand(AddCoursesData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)
				&& !commandData.getCredentialsUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		if (userDao.selectByUsername(getHandle(), commandData.getCredentialsUsername()) == null) {
			throwBadRequest(commandData.getCredentialsUsername() + " does not exist");
		}
		for (String courseId : commandData.getCourseIdList()) {
			if (courseDao.selectByCourseId(getHandle(), courseId) == null) {
				throwBadRequest("course with id " + courseId + " does not exist");
			}
		}
		this.commandData.setOutcome(success);
	}

}

/* S.D.G. */
