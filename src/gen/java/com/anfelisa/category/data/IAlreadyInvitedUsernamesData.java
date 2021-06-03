/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.IAlreadyInvitedUsernamesModel;

@JsonDeserialize(as=AlreadyInvitedUsernamesData.class)
public interface IAlreadyInvitedUsernamesData extends IAlreadyInvitedUsernamesModel, IDataContainer {
	
	IAlreadyInvitedUsernamesData withCategoryId(String categoryId);
	
	IAlreadyInvitedUsernamesData withUserId(String userId);
	
	IAlreadyInvitedUsernamesData withInvitedUsernames(java.util.List<String> invitedUsernames);
	
	
	IAlreadyInvitedUsernamesData deepCopy();
}



/******* S.D.G. *******/



