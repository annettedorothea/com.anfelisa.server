package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.UsernameData;
import com.anfelisa.user.models.UserDao;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	private UserDao userDao = new UserDao();
	
	public ConfirmEmailCommand(UsernameData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (userDao.selectByUsername(getHandle(), commandData.getUsername()) == null) {
			throwBadRequest(commandData.getUsername() + " does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
