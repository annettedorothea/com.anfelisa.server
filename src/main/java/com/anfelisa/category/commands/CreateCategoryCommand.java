package com.anfelisa.category.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryCreationData;

public class CreateCategoryCommand extends AbstractCreateCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryCommand.class);

	public CreateCategoryCommand(CategoryCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public CreateCategoryCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCategoryIndex() == null) {
			commandData.setCategoryIndex(0);
		}
		this.commandData.setCategoryId(commandData.getUuid());
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
