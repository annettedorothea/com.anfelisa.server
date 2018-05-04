package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.EmailConfirmationData;
import com.anfelisa.user.models.EmailConfirmationDao;
import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class ConfirmEmailCommand extends AbstractConfirmEmailCommand {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailCommand.class);

	private EmailConfirmationDao emailConfirmationDao = new EmailConfirmationDao();
	private UserDao userDao = new UserDao();

	public ConfirmEmailCommand(EmailConfirmationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		IEmailConfirmationModel emailConfirmation = emailConfirmationDao.selectByToken(getHandle(),
				commandData.getToken());
		if (emailConfirmation == null) {
			throwBadRequest("Token not found.");
		}
		IUserModel user = userDao.selectByUserId(getHandle(), emailConfirmation.getUserId());
		if (user == null) {
			throwBadRequest("User does not exist.");
		}
		this.commandData.setUserId(user.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */
