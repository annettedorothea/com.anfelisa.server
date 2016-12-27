package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IPointsModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=PointsData.class)
public interface IPointsData extends IPointsModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
