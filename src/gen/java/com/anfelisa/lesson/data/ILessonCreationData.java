package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonModel;

@JsonDeserialize(as=LessonCreationData.class)
public interface ILessonCreationData extends ILessonModel, IDataContainer {

}

/*       S.D.G.       */
