/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ProfileUserModel.class)
public interface IProfileUserModel extends com.anfelisa.user.models.IUserModel{

	Boolean getDeletable();
	void setDeletable(Boolean deletable);
	
	
	IProfileUserModel deepCopy();
}




/******* S.D.G. *******/


