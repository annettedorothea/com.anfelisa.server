package com.anfelisa.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardContentHashListModel.class)
public interface ICardContentHashListModel {

	java.util.List<Integer> getContentHashList();


}

/*       S.D.G.       */
