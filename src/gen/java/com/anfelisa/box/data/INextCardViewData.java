package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextCardViewModel;

@JsonDeserialize(as=NextCardViewData.class)
public interface INextCardViewData extends INextCardViewModel, IDataContainer {
}

/*       S.D.G.       */
