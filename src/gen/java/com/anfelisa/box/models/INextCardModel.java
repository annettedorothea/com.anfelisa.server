package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel {

	String getScheduledCardId();
	String getCardId();
	org.joda.time.DateTime getScheduledDate();
	Integer getLastQuality();
	String getGiven();
	String getWanted();
	String getImage();
	String getCategoryId();
	String getRootCategoryId();
	Integer getCount();
	org.joda.time.DateTime getScoredDate();

}

/*       S.D.G.       */
