package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextCardViewModel.class)
public interface INextCardViewModel {

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
	String getBoxId();

}

/*       S.D.G.       */
