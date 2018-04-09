package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.models.CourseDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.RemoveCourseData;
import com.anfelisa.user.models.UserDao;

public class RemoveCourseCommand extends AbstractRemoveCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCourseCommand.class);

	private UserDao userDao = new UserDao();

	private CourseDao courseDao = new CourseDao();

	public RemoveCourseCommand(RemoveCourseData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (userDao.selectByUsername(getHandle(), commandData.getUsername()) == null) {
			throwBadRequest(commandData.getUsername() + " does not exist");
		}
		if (courseDao.selectByCourseId(getHandle(), commandData.getCourseId()) == null) {
			throwBadRequest("course with id " + commandData.getCourseId() + " does not exist");
		}
		this.commandData.setOutcome(success);
	}

}

/* S.D.G. */
