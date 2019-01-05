package com.anfelisa.category.actions;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jdbi.v3.core.Jdbi;

public class MoveCategoryAction extends AbstractMoveCategoryAction {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryAction.class);

	public MoveCategoryAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}



}

/*       S.D.G.       */
