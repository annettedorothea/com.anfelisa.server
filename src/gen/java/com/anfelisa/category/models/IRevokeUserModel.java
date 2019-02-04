package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=RevokeUserModel.class)
public interface IRevokeUserModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	String getRevokedUserId();
	void setRevokedUserId(String revokedUserId);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(IRevokeUserModel other);
	
}

/*       S.D.G.       */
