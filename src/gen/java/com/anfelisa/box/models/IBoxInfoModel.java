package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxInfoModel.class)
public interface IBoxInfoModel extends com.anfelisa.box.models.IBoxViewModel{

	String getUserId();
	org.joda.time.DateTime getToday();

}

/*       S.D.G.       */
