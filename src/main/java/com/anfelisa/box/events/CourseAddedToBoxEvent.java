package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxToCourseAdditionData;

public class CourseAddedToBoxEvent extends AbstractCourseAddedToBoxEvent {

	static final Logger LOG = LoggerFactory.getLogger(CourseAddedToBoxEvent.class);

	public CourseAddedToBoxEvent(BoxToCourseAdditionData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
