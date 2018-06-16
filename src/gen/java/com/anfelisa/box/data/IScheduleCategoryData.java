package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScheduleCategoryModel;
import com.anfelisa.box.models.ITodayModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduleCategoryData.class)
public interface IScheduleCategoryData extends IScheduleCategoryModel, ITodayModel, IDataContainer {

}

/*       S.D.G.       */
