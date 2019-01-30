package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.data.IInviteUserData;
import com.anfelisa.category.data.IRevokeUserData;

@SuppressWarnings("all")
public interface IUserAccessToCategoryView {

	void grantAccess(ICategoryCreationData data, Handle handle);
	void grantAccessInvitation(IInviteUserData data, Handle handle);
	void revokeAccess(IRevokeUserData data, Handle handle);

}

/*                    S.D.G.                    */
