package com.anfelisa.category.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryCreationData;

public class CreateCategoryOkEvent extends AbstractCreateCategoryOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryOkEvent.class);

	public CreateCategoryOkEvent(CategoryCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateCategoryOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
