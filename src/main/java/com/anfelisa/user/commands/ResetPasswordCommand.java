package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ResetPasswordData;
import com.anfelisa.user.models.IResetPasswordModel;
import com.anfelisa.user.models.ResetPasswordDao;

public class ResetPasswordCommand extends AbstractResetPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordCommand.class);

	private ResetPasswordDao resetPasswordDao = new ResetPasswordDao();
	
	public ResetPasswordCommand(ResetPasswordData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public ResetPasswordCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IResetPasswordModel model = resetPasswordDao.selectByToken(getHandle(), commandData.getToken());
		if (model == null)  {
			throwBadRequest("Token not found.");
		}
		this.commandData.setUserId(model.getUserId());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
