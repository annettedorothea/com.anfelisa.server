package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxViewModel;

@JsonDeserialize(as=BoxViewData.class)
public interface IBoxViewData extends IBoxViewModel, IDataContainer {
}

/*       S.D.G.       */
