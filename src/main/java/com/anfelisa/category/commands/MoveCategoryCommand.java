package com.anfelisa.category.commands;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.CategoryMoveData;

public class MoveCategoryCommand extends AbstractMoveCategoryCommand {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryCommand.class);

	public MoveCategoryCommand(CategoryMoveData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
	super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */
