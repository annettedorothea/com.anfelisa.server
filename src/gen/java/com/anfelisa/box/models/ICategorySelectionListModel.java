package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategorySelectionListModel.class)
public interface ICategorySelectionListModel {

	java.util.List<com.anfelisa.box.models.ICategorySelectionItemModel> getCategoryList();

}

/*       S.D.G.       */
