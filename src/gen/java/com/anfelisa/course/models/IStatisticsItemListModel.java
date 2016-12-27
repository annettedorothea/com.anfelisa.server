package com.anfelisa.course.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=StatisticsItemListModel.class)
public interface IStatisticsItemListModel {


	java.util.List<com.anfelisa.course.models.IStatisticsItemModel> getStatisticsItemList();

}

/*       S.D.G.       */
