package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteBoxModel.class)
public interface IDeleteBoxModel {

	Integer getBoxId();


}

/*       S.D.G.       */
