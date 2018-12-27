package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IPasswordModel;

@JsonDeserialize(as=PasswordData.class)
public interface IPasswordData extends IPasswordModel, IDataContainer {

}

/*       S.D.G.       */
