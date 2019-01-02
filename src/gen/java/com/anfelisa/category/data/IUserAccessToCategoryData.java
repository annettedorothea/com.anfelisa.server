package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IUserAccessToCategoryModel;

@JsonDeserialize(as=UserAccessToCategoryData.class)
public interface IUserAccessToCategoryData extends IUserAccessToCategoryModel, IDataContainer {
}

/*       S.D.G.       */
