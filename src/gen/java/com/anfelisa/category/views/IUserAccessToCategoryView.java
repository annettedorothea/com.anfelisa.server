package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.InviteUserData;
import com.anfelisa.category.data.RevokeUserData;

@SuppressWarnings("all")
public interface IUserAccessToCategoryView {

	void grantAccess(CategoryCreationData data, Handle handle);
	void grantAccessInvitation(InviteUserData data, Handle handle);
	void revokeAccess(RevokeUserData data, Handle handle);

}

/*                    S.D.G.                    */
