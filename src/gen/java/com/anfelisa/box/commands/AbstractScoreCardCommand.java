/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.PersistenceHandle;

import com.anfelisa.box.data.IScoreCardData;

public abstract class AbstractScoreCardCommand extends Command<IScoreCardData> {

	protected static final String score = "score";
	protected static final String scoreAndReinforce = "scoreAndReinforce";

	public AbstractScoreCardCommand(IScoreCardData commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.box.commands.ScoreCardCommand", commandParam, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	public void publishEvents(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		switch (this.commandData.getOutcome()) {
		case score:
			new com.anfelisa.box.events.ScoreCardScoreEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		case scoreAndReinforce:
			new com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
}




/******* S.D.G. *******/



