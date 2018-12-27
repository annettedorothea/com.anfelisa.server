package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IRevokeUserModel;

@JsonDeserialize(as=RevokeUserData.class)
public interface IRevokeUserData extends IRevokeUserModel, IDataContainer {

}

/*       S.D.G.       */
