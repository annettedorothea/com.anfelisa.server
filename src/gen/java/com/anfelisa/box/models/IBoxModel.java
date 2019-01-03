package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxModel.class)
public interface IBoxModel {

	String getBoxId();
	void setBoxId(String boxId);
	
	String getUserId();
	void setUserId(String userId);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	Integer getMaxInterval();
	void setMaxInterval(Integer maxInterval);
	

}

/*       S.D.G.       */
