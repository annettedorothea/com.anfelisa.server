package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel extends com.anfelisa.box.models.INextCardViewModel{

	String getUserId();
	org.joda.time.DateTime getToday();

}

/*       S.D.G.       */
