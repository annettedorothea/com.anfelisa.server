package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
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
	
	
	List<String> equalsPrimitiveTypes(INextReinforceCardViewModel other);
	
}

/*       S.D.G.       */
