package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IUserWithAccessModel;

@JsonDeserialize(as=UserWithAccessData.class)
public interface IUserWithAccessData extends IUserWithAccessModel, IDataContainer {

}

/*       S.D.G.       */
