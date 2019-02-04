package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
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
	
	
	List<String> equalsPrimitiveTypes(IScoreReinforceCardModel other);
	
}

/*       S.D.G.       */
