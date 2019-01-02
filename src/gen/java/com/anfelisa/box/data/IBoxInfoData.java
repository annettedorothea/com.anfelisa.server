package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxInfoModel;

@JsonDeserialize(as=BoxInfoData.class)
public interface IBoxInfoData extends IBoxInfoModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IBoxViewModel model);
}

/*       S.D.G.       */
