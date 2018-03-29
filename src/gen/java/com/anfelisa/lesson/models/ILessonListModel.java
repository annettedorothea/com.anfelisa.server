package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LessonListModel.class)
public interface ILessonListModel {

	java.util.List<com.anfelisa.lesson.models.ILessonModel> getLessonList();

}

/*       S.D.G.       */
