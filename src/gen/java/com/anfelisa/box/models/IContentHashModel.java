package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ContentHashModel.class)
public interface IContentHashModel {

	String getContentHash();

}

/*       S.D.G.       */
