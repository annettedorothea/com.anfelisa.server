package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=InviteUserModel.class)
public interface IInviteUserModel {

	String getCategoryId();
	String getRootCategoryId();
	String getInvitedUserId();
	String getInvitedUsername();
	String getUserId();

}

/*       S.D.G.       */
