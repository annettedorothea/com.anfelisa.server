package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PointsModel.class)
public interface IPointsModel {

	Integer getPoints();

}

/*       S.D.G.       */
