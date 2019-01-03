package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextReinforceCardViewModel.class)
public interface INextReinforceCardViewModel {

	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	org.joda.time.DateTime getChangeDate();
	void setChangeDate(org.joda.time.DateTime changeDate);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getImage();
	void setImage(String image);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	

}

/*       S.D.G.       */
