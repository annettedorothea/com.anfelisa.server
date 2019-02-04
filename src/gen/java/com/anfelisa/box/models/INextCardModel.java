package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextCardModel.class)
public interface INextCardModel extends com.anfelisa.box.models.INextCardViewModel{

	String getUserId();
	void setUserId(String userId);
	
	org.joda.time.DateTime getToday();
	void setToday(org.joda.time.DateTime today);
	
	
	List<String> equalsPrimitiveTypes(INextCardModel other);
	
}

/*       S.D.G.       */
