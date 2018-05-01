package com.anfelisa.category.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryDeleteData;

public class DeleteCategoryOkEvent extends AbstractDeleteCategoryOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryOkEvent.class);

	public DeleteCategoryOkEvent(CategoryDeleteData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteCategoryOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
