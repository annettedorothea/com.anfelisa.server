package com.anfelisa.course.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.course.models.IStatisticsModel;
import com.anfelisa.course.models.IStatisticsItemListModel;

@JsonDeserialize(as=StatisticsData.class)
public interface IStatisticsData extends IStatisticsModel, IStatisticsItemListModel, IDataContainer {

}

/*       S.D.G.       */
