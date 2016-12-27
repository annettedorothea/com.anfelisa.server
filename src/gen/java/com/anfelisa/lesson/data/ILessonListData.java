package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonListModel;
import com.anfelisa.course.models.ICourseIdModel;
import com.anfelisa.course.models.ICourseAbstractModel;

@JsonDeserialize(as=LessonListData.class)
public interface ILessonListData extends ILessonListModel, ICourseIdModel, ICourseAbstractModel, IDataContainer {

}

/*       S.D.G.       */
