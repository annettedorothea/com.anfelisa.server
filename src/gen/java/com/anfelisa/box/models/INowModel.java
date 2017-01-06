package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NowModel.class)
public interface INowModel {

	org.joda.time.DateTime getNow();


}

/*       S.D.G.       */
