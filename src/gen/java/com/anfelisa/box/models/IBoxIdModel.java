package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxIdModel.class)
public interface IBoxIdModel {

	Integer getBoxId();


}

/*       S.D.G.       */
