package com.anfelisa.result.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultIdModel.class)
public interface IResultIdModel {

	Integer getResultId();

}

/*       S.D.G.       */
