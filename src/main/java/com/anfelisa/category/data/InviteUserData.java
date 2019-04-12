package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InviteUserData extends AbstractInviteUserData implements IInviteUserData {
	
	public InviteUserData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("invitedUserId") String invitedUserId, 
		@JsonProperty("invitedUsername") String invitedUsername, 
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			rootCategoryId,
			invitedUserId,
			invitedUsername,
			editable,
			userId,
			uuid
		);
	}

	public InviteUserData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IInviteUserData original = (IInviteUserData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IInviteUserData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
