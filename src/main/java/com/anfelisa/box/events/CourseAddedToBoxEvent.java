package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public class CourseAddedToBoxEvent extends AbstractCourseAddedToBoxEvent {

	static final Logger LOG = LoggerFactory.getLogger(CourseAddedToBoxEvent.class);

	public CourseAddedToBoxEvent(BoxToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CourseAddedToBoxEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
