package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.AddCoursesData;

public class AddCoursesSuccessEvent extends AbstractAddCoursesSuccessEvent {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesSuccessEvent.class);

	public AddCoursesSuccessEvent(AddCoursesData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public AddCoursesSuccessEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
