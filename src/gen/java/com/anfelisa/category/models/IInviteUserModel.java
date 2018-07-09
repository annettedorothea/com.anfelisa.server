package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=InviteUserModel.class)
public interface IInviteUserModel {

	String getCategoryId();
	String getInvitedUserId();
	String getUsername();

}

/*       S.D.G.       */
