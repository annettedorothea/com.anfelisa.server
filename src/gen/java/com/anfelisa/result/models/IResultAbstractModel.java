package com.anfelisa.result.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultAbstractModel.class)
public interface IResultAbstractModel {

	Integer getResultId();
	org.joda.time.DateTime getDate();
	Integer getPoints();
	Integer getMaxPoints();


}

/*       S.D.G.       */
