package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextReinforceCardViewModel;

@JsonDeserialize(as=NextReinforceCardViewData.class)
public interface INextReinforceCardViewData extends INextReinforceCardViewModel, IDataContainer {
}

/*       S.D.G.       */
