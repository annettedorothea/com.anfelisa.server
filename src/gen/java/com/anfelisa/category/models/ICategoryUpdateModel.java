package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryUpdateModel.class)
public interface ICategoryUpdateModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	Boolean getDictionaryLookup();
	void setDictionaryLookup(Boolean dictionaryLookup);
	
	String getGivenLanguage();
	void setGivenLanguage(String givenLanguage);
	
	String getWantedLanguage();
	void setWantedLanguage(String wantedLanguage);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(ICategoryUpdateModel other);
	
}

/*       S.D.G.       */
