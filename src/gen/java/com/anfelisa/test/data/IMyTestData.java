package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestModel;
import com.anfelisa.lesson.models.ILessonIdModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;
import com.anfelisa.test.models.IMyTestListModel;

@JsonDeserialize(as=MyTestData.class)
public interface IMyTestData extends ITestModel, ILessonIdModel, IUsernameModel, ILessonAbstractModel, ICourseAbstractModel, IMyTestListModel, IDataContainer {

}

/*       S.D.G.       */
