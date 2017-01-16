package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxConfigData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxOfCourseDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxOfCourseModel;

public class SaveBoxConfigCommand extends AbstractSaveBoxConfigCommand {

	static final Logger LOG = LoggerFactory.getLogger(SaveBoxConfigCommand.class);

	private BoxDao boxDao = new BoxDao();

	private CustomBoxOfCourseDao customBoxOfCourseDao = new CustomBoxOfCourseDao();

	public SaveBoxConfigCommand(BoxConfigData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = boxDao.selectByBoxId(this.getHandle(), commandData.getBoxId(), commandData.getSchema());
		if ((commandData.getCredentialsRole().equals(AuthUser.STUDENT))
				&& !box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		List<IBoxOfCourseModel> list = this.commandData.getBoxOfCourseList();
		this.commandData.setExistingItems(new ArrayList<IBoxOfCourseModel>());
		for (IBoxOfCourseModel item : list) {
			IBoxOfCourseModel existingItem = customBoxOfCourseDao.select(this.getDatabaseHandle().getHandle(),
					this.commandData.getSchema(), item.getBoxId(), item.getCourseId());
			this.commandData.getExistingItems().add(existingItem);
		}
		this.outcome = saved;
	}

}

/* S.D.G. */
