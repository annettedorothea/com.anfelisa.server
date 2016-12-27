package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardContentModel.class)
public interface ICardContentModel {

	Boolean getComplex();
	String getGiven();
	Boolean getLarge();
	String getWanted();
	String getHeader();

	java.util.List<com.anfelisa.box.models.ILineModel> getLines();

}

/*       S.D.G.       */
