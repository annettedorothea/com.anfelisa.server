package com.anfelisa.category.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryUpdateData;

public class UpdateCategoryOkEvent extends AbstractUpdateCategoryOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCategoryOkEvent.class);

	public UpdateCategoryOkEvent(CategoryUpdateData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateCategoryOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
