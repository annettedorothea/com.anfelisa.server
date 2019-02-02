package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxListModel.class)
public interface IBoxListModel {

	java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList();
	void setBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList);
	
	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	
}

/*       S.D.G.       */
