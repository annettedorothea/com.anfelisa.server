package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScoredCardModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoredCardData.class)
public interface IScoredCardData extends IScoredCardModel, IDataContainer {

}

/*       S.D.G.       */
