package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.ILessonIdModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.ITestListModel;

@JsonDeserialize(as=TestData.class)
public interface ITestData extends ITestModel, ILessonIdModel, ILessonAbstractModel, ICourseAbstractModel, ITestListModel, IDataContainer {

}

/*       S.D.G.       */
