/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.data;

public class GetInvitedUsersResponse {
	
	private java.util.List<com.anfelisa.category.models.UsernameEditableModel> invitedUsers;
	
	public GetInvitedUsersResponse() {
	}
	
	public GetInvitedUsersResponse(com.anfelisa.category.models.AlreadyInvitedUsernamesModel model) {
		invitedUsers = model.getInvitedUsers();
	}
	
	public java.util.List<com.anfelisa.category.models.UsernameEditableModel> getInvitedUsers() {
		return this.invitedUsers;
	}
	
	
	
}



/******* S.D.G. *******/



