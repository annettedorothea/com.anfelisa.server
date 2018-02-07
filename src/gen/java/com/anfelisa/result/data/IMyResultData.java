package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.lesson.models.ILessonIdModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.IMyTestListModel;

@JsonDeserialize(as=MyResultData.class)
public interface IMyResultData extends IResultModel, ITestModel, ILessonIdModel, ILessonAbstractModel, ICourseAbstractModel, IMyTestListModel, IDataContainer {

}

/*       S.D.G.       */
