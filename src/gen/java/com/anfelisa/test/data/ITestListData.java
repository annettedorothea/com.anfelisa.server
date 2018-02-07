package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestListModel;
import com.anfelisa.lesson.models.ILessonIdModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@JsonDeserialize(as=TestListData.class)
public interface ITestListData extends ITestListModel, ILessonIdModel, ILessonAbstractModel, ICourseAbstractModel, IDataContainer {

}

/*       S.D.G.       */
