package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxInfoModel.class)
public interface IBoxInfoModel extends com.anfelisa.box.models.IBoxViewModel{

	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	
	List<String> equalsPrimitiveTypes(IBoxInfoModel other);
	
}

/*       S.D.G.       */
