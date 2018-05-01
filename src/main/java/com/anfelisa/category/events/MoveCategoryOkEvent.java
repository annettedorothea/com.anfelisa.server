package com.anfelisa.category.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.category.data.CategoryMoveData;

public class MoveCategoryOkEvent extends AbstractMoveCategoryOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(MoveCategoryOkEvent.class);

	public MoveCategoryOkEvent(CategoryMoveData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public MoveCategoryOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
