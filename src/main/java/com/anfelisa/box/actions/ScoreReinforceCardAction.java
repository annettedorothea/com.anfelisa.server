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




package com.anfelisa.box.actions;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.E2E;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class ScoreReinforceCardAction extends AbstractScoreReinforceCardAction {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardAction.class);

	public ScoreReinforceCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
			ViewProvider viewProvider, E2E e2e) {
		super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);
	}


	
	public void initActionData() {
		// init not replayable data here
	}

}




/******* S.D.G. *******/



