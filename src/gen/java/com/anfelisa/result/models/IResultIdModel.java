package com.anfelisa.result.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultIdModel.class)
public interface IResultIdModel {

	String getResultId();

}

/*       S.D.G.       */
