package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DaysBehindModel.class)
public interface IDaysBehindModel {

	Integer getDaysBehind();


}

/*       S.D.G.       */
