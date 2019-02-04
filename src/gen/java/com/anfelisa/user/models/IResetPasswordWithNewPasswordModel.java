package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ResetPasswordWithNewPasswordModel.class)
public interface IResetPasswordWithNewPasswordModel extends com.anfelisa.user.models.IResetPasswordModel{

	String getPassword();
	void setPassword(String password);
	
	
	List<String> equalsPrimitiveTypes(IResetPasswordWithNewPasswordModel other);
	
}

/*       S.D.G.       */
