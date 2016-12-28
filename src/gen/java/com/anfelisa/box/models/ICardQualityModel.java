package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardQualityModel.class)
public interface ICardQualityModel {

	Integer getSubmittedQuality();


}

/*       S.D.G.       */
