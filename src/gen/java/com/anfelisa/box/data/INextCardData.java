package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextCardModel;

@JsonDeserialize(as=NextCardData.class)
public interface INextCardData extends INextCardModel, IDataContainer {

}

/*       S.D.G.       */
