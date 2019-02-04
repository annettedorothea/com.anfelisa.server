package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextCardViewModel.class)
public interface INextCardViewModel {

	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getCardId();
	void setCardId(String cardId);
	
	org.joda.time.DateTime getScheduledDate();
	void setScheduledDate(org.joda.time.DateTime scheduledDate);
	
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
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	Integer getCount();
	void setCount(Integer count);
	
	org.joda.time.DateTime getScoredDate();
	void setScoredDate(org.joda.time.DateTime scoredDate);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	List<String> equalsPrimitiveTypes(INextCardViewModel other);
	
}

/*       S.D.G.       */
