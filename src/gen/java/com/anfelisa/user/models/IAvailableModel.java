package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=AvailableModel.class)
public interface IAvailableModel {

	Boolean getAvailable();

}

/*       S.D.G.       */
