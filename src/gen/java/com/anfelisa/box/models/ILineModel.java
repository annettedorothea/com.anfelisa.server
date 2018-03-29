package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LineModel.class)
public interface ILineModel {

	java.util.List<String> getWords();

}

/*       S.D.G.       */
