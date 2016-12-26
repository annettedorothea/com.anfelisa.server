package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxOfCourseListData;

public class CoursesAddedToBoxEvent extends AbstractCoursesAddedToBoxEvent {

	static final Logger LOG = LoggerFactory.getLogger(CoursesAddedToBoxEvent.class);

	public CoursesAddedToBoxEvent(BoxOfCourseListData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
