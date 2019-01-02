package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.InviteUserData;
import com.anfelisa.category.data.RevokeUserData;
import com.anfelisa.category.models.UserAccessToCategoryModel;

public class UserAccessToCategoryView implements IUserAccessToCategoryView {

	private IDaoProvider daoProvider;

	public UserAccessToCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void grantAccess(CategoryCreationData data, Handle handle) {
		daoProvider.getUserAccessToCategoryDao().insert(handle, data);
	}

	public void grantAccessInvitation(InviteUserData data, Handle handle) {
		daoProvider.getUserAccessToCategoryDao().insert(handle,
				new UserAccessToCategoryModel(data.getRootCategoryId(), data.getInvitedUserId()));
	}

	public void revokeAccess(RevokeUserData data, Handle handle) {
		daoProvider.getUserAccessToCategoryDao().deleteByCategoryIdAndUserId(handle, data.getRootCategoryId(),
				data.getRevokedUserId());
	}

}

/* S.D.G. */
