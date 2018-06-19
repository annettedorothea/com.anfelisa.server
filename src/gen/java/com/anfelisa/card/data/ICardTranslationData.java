package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.card.models.ICardTranslationModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardTranslationData.class)
public interface ICardTranslationData extends ICardTranslationModel, IDataContainer {

}

/*       S.D.G.       */
