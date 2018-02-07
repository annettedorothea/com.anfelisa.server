package com.anfelisa.lesson.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonIdModel;

@JsonDeserialize(as=LessonIdData.class)
public interface ILessonIdData extends ILessonIdModel, IDataContainer {

}

/*       S.D.G.       */
