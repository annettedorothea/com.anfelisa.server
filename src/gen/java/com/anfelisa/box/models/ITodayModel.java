package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=TodayModel.class)
public interface ITodayModel {

	org.joda.time.DateTime getToday();

}

/*       S.D.G.       */
