package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardIdModel.class)
public interface IScheduledCardIdModel {

	Integer getScheduledCardId();


}

/*       S.D.G.       */