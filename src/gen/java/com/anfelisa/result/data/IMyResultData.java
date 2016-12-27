package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultModel;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.ILessonIdModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.IMyTestListModel;

@JsonDeserialize(as=MyResultData.class)
public interface IMyResultData extends IResultModel, ITestModel, ILessonIdModel, IUsernameModel, ILessonAbstractModel, ICourseAbstractModel, IMyTestListModel, IDataContainer {

}

/*       S.D.G.       */
