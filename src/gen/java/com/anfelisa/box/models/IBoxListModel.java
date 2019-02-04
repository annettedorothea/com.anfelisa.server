package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxListModel.class)
public interface IBoxListModel {

	java.util.List<com.anfelisa.box.models.IBoxViewModel> getBoxList();
	void setBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList);
	
	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	
	List<String> equalsPrimitiveTypes(IBoxListModel other);
	
}

/*       S.D.G.       */
