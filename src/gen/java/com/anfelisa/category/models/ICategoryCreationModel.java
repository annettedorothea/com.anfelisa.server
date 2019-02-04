package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryCreationModel.class)
public interface ICategoryCreationModel extends com.anfelisa.category.models.ICategoryModel,com.anfelisa.category.models.IUserAccessToCategoryModel{

	String getUsername();
	void setUsername(String username);
	
	
	List<String> equalsPrimitiveTypes(ICategoryCreationModel other);
	
}

/*       S.D.G.       */
