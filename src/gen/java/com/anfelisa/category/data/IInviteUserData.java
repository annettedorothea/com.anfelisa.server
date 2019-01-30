package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IInviteUserModel;

@JsonDeserialize(as=InviteUserData.class)
public interface IInviteUserData extends IInviteUserModel, IDataContainer {
	
	IInviteUserData withCategoryId(String categoryId);
	
	IInviteUserData withRootCategoryId(String rootCategoryId);
	
	IInviteUserData withInvitedUserId(String invitedUserId);
	
	IInviteUserData withInvitedUsername(String invitedUsername);
	
	IInviteUserData withUserId(String userId);
	
	
}

/*       S.D.G.       */
