/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardWithStatisticsModel.class)
public interface ICardWithStatisticsModel extends com.anfelisa.card.models.ICardWithInfoModel{

	Float getEf();
	void setEf(Float ef);
	
	Integer getInterval();
	void setInterval(Integer interval);
	
	Integer getCount();
	void setCount(Integer count);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	
	ICardWithStatisticsModel deepCopy();
}




/******* S.D.G. *******/



