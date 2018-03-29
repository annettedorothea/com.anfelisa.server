package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LessonIdModel.class)
public interface ILessonIdModel {

	Integer getLessonId();

}

/*       S.D.G.       */
