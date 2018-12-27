package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILanguageModel;

@JsonDeserialize(as=LanguageData.class)
public interface ILanguageData extends ILanguageModel, IDataContainer {

}

/*       S.D.G.       */
