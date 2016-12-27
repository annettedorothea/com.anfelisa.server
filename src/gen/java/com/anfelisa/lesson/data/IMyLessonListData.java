package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.IMyLessonListModel;
import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.course.models.ICourseIdModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@JsonDeserialize(as=MyLessonListData.class)
public interface IMyLessonListData extends IMyLessonListModel, IUsernameModel, ICourseIdModel, ICourseAbstractModel, IDataContainer {

}

/*       S.D.G.       */
