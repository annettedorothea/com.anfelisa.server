package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxUpdateModel.class)
public interface IBoxUpdateModel {

	String getUserId();
	String getBoxId();
	Integer getMaxInterval();

}

/*       S.D.G.       */
