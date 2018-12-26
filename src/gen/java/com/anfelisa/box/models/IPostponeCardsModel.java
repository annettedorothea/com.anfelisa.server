package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PostponeCardsModel.class)
public interface IPostponeCardsModel {

	Integer getDays();

}

/*       S.D.G.       */
