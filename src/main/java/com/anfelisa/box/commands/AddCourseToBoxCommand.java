package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxToCourseAdditionData;

public class AddCourseToBoxCommand extends AbstractAddCourseToBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxCommand.class);

	public AddCourseToBoxCommand(BoxToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		/*DatabaseHandle handle = this.createDatabaseHandle();
		IBoxModel box = BoxDao.selectByBoxId(handle.getHandle(), actionParam.getBoxId(), actionParam.getSchema());
		if (user.getRole().equals(AuthUser.STUDENT) && !box.getUsername().equals(user.getUsername())) {
			handle.close();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}*/
		this.outcome = added;
	}

}

/*       S.D.G.       */
