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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ScoreReinforceCardCommand extends AbstractScoreReinforceCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardCommand.class);

	public ScoreReinforceCardCommand(IScoreReinforceCardData commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(commandData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IReinforceCardModel reinforceCard = this.daoProvider.getReinforceCardDao().selectByReinforceCardId(readonlyHandle, commandData.getReinforceCardId());
		if (reinforceCard == null) {
			throwIllegalArgumentException("cardDoesNotExist");
		}
		IBoxModel box = this.daoProvider.getBoxDao().selectByBoxId(readonlyHandle, reinforceCard.getBoxId());
		if (!box.getUserId().equals(this.commandData.getUserId())) {
			throwSecurityException();
		}
		if (this.commandData.getScoredCardQuality() > 3) {
			this.commandData.setOutcome(remove);
		} else {
			this.commandData.setChangeDate(this.commandData.getSystemTime());
			this.commandData.setOutcome(keep);
		}
	}

}




/******* S.D.G. *******/



