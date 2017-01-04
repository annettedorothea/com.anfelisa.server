package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;

public class DeleteObsoleteCardsCommand extends AbstractDeleteObsoleteCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteObsoleteCardsCommand.class);

	public DeleteObsoleteCardsCommand(ContentHashesOfCreatedCardsData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		for (String contentHashOfCreatedCard : this.commandData.getContentHashesOfCreatedCards()) {
			this.commandData.getContentHashesOfObsoleteCards().remove(contentHashOfCreatedCard);
		};
		this.outcome = deleted;
	}

}

/*       S.D.G.       */
