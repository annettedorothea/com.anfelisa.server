package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreReinforceCardModel.class)
public interface IScoreReinforceCardModel {

	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	Integer getQuality();
	void setQuality(Integer quality);
	
	org.joda.time.DateTime getChangeDate();
	void setChangeDate(org.joda.time.DateTime changeDate);
	
	String getUserId();
	void setUserId(String userId);
	

}

/*       S.D.G.       */
