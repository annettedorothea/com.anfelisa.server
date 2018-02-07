package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.IMyTestListModel;
import com.anfelisa.lesson.models.ILessonIdModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.lesson.models.ILessonAbstractModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@JsonDeserialize(as=MyTestListData.class)
public interface IMyTestListData extends IMyTestListModel, ILessonIdModel, IUsernameModel, ILessonAbstractModel, ICourseAbstractModel, IDataContainer {

}

/*       S.D.G.       */
