package com.anfelisa.course.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class StatisticsItemListModel implements IStatisticsItemListModel {

	private java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList;
	

	public StatisticsItemListModel(
		@JsonProperty("statisticsItemList") java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList
	) {
		this.statisticsItemList = statisticsItemList;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.course.models.IStatisticsItemModel> getStatisticsItemList() {
		return this.statisticsItemList;
	}
	public void setStatisticsItemList(java.util.List<com.anfelisa.course.models.IStatisticsItemModel> statisticsItemList) {
		this.statisticsItemList = statisticsItemList;
	}
	

}

/*       S.D.G.       */
