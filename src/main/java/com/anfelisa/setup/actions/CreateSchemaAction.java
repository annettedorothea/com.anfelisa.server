package com.anfelisa.setup.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SchemaCreationData;

public class CreateSchemaAction extends AbstractCreateSchemaAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateSchemaAction.class);

	public CreateSchemaAction(SchemaCreationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
	}

}

/*       S.D.G.       */
