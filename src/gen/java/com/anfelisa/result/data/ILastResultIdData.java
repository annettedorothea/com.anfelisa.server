package com.anfelisa.result.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.result.models.IResultIdModel;
import com.anfelisa.test.models.ITestIdModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=LastResultIdData.class)
public interface ILastResultIdData extends IResultIdModel, ITestIdModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
