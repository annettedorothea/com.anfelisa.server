package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonListModel;
import com.anfelisa.course.models.ICourseIdModel;

@JsonDeserialize(as=SimpleLessonListData.class)
public interface ISimpleLessonListData extends ILessonListModel, ICourseIdModel, IDataContainer {

}

/*       S.D.G.       */
