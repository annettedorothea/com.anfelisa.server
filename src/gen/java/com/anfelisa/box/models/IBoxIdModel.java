package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxIdModel.class)
public interface IBoxIdModel {

	String getBoxId();

}

/*       S.D.G.       */
