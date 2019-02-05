package com.anfelisa.card.actions;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

public class DeleteCardAction extends AbstractDeleteCardAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardAction.class);

	public DeleteCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);
	}

	@Override
	public void initActionData() {
	}


}

/*       S.D.G.       */
