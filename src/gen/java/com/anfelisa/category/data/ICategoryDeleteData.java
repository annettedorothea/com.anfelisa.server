package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.models.ICategoryDeleteModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryDeleteData.class)
public interface ICategoryDeleteData extends ICategoryDeleteModel, IDataContainer {

}

/*       S.D.G.       */
