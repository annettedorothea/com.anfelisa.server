package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IInviteUserModel;

@JsonDeserialize(as=InviteUserData.class)
public interface IInviteUserData extends IInviteUserModel, IDataContainer {

}

/*       S.D.G.       */
