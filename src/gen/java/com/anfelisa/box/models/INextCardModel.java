package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel extends com.anfelisa.box.models.INextCardViewModel{

	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	

}

/*       S.D.G.       */
