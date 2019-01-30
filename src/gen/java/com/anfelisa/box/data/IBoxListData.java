package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxListModel;

@JsonDeserialize(as=BoxListData.class)
public interface IBoxListData extends IBoxListModel, IDataContainer {
	
	IBoxListData withBoxList(java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList);
	
	IBoxListData withUserId(String userId);
	
	IBoxListData withToday(org.joda.time.DateTime today);
	
	
}

/*       S.D.G.       */
