package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxUpdateModel;

@JsonDeserialize(as=BoxUpdateData.class)
public interface IBoxUpdateData extends IBoxUpdateModel, IDataContainer {
}

/*       S.D.G.       */
