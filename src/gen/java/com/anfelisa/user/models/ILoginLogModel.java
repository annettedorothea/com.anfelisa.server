package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LoginLogModel.class)
public interface ILoginLogModel {

	Integer getLoginLogId();
	String getUsername();
	org.joda.time.DateTime getDate();

}

/*       S.D.G.       */
