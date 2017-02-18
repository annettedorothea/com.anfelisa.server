package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;

public class AddCourseToBoxCommand extends AbstractAddCourseToBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxCommand.class);

	private BoxDao boxDao = new BoxDao();

	public AddCourseToBoxCommand(BoxToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), commandData.getBoxId());
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)
				&& !box.getUsername().equals(commandData.getCredentialsUsername())) {
			this.throwUnauthorized();
		}
		this.outcome = added;
	}

}

/* S.D.G. */
