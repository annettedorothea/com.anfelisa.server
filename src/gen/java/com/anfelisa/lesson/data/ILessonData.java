package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonModel;

@JsonDeserialize(as=LessonData.class)
public interface ILessonData extends ILessonModel, IDataContainer {

}

/*       S.D.G.       */
