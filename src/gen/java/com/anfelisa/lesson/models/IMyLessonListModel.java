package com.anfelisa.lesson.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyLessonListModel.class)
public interface IMyLessonListModel {

	java.util.List<com.anfelisa.lesson.models.IMyLessonModel> getMyLessonList();

}

/*       S.D.G.       */
