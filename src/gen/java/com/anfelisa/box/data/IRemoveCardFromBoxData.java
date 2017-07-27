package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardIdModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=RemoveCardFromBoxData.class)
public interface IRemoveCardFromBoxData extends IScheduledCardIdModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
