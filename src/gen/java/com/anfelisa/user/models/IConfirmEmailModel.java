package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ConfirmEmailModel.class)
public interface IConfirmEmailModel extends com.anfelisa.user.models.IEmailConfirmationModel{

	String getUsername();
	void setUsername(String username);
	
	
	List<String> equalsPrimitiveTypes(IConfirmEmailModel other);
	
}

/*       S.D.G.       */
