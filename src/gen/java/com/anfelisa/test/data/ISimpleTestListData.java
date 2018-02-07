package com.anfelisa.test.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.test.models.ITestListModel;
import com.anfelisa.lesson.models.ILessonIdModel;

@JsonDeserialize(as=SimpleTestListData.class)
public interface ISimpleTestListData extends ITestListModel, ILessonIdModel, IDataContainer {

}

/*       S.D.G.       */
