package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.models.ICategoryUpdateModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryUpdateData.class)
public interface ICategoryUpdateData extends ICategoryUpdateModel, IDataContainer {

}

/*       S.D.G.       */
