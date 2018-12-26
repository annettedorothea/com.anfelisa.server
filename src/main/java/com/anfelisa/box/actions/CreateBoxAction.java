package com.anfelisa.box.actions;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jdbi.v3.core.Jdbi;

public class CreateBoxAction extends AbstractCreateBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxAction.class);

	public CreateBoxAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}



}

/*       S.D.G.       */
