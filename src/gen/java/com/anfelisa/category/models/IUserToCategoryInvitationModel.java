/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserToCategoryInvitationModel.class)
public interface IUserToCategoryInvitationModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getUserId();
	void setUserId(String userId);
	
	String getInvitedUsername();
	void setInvitedUsername(String invitedUsername);
	
	String getInvitedUserId();
	void setInvitedUserId(String invitedUserId);
	
	com.anfelisa.box.models.IBoxModel getBoxForInvitedUser();
	void setBoxForInvitedUser(com.anfelisa.box.models.IBoxModel boxForInvitedUser);
	
	
	IUserToCategoryInvitationModel deepCopy();
}




/******* S.D.G. *******/



