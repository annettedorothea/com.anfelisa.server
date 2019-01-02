package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextReinforceCardViewModel.class)
public interface INextReinforceCardViewModel {

	String getReinforceCardId();
	org.joda.time.DateTime getChangeDate();
	Integer getLastQuality();
	String getGiven();
	String getWanted();
	String getImage();
	String getCategoryId();

}

/*       S.D.G.       */
