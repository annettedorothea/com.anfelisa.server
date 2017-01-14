package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IPointsModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=PointsData.class)
public interface IPointsData extends IPointsModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
