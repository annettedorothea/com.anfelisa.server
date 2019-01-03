package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=InviteUserModel.class)
public interface IInviteUserModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	String getInvitedUserId();
	void setInvitedUserId(String invitedUserId);
	
	String getInvitedUsername();
	void setInvitedUsername(String invitedUsername);
	
	String getUserId();
	void setUserId(String userId);
	

}

/*       S.D.G.       */
