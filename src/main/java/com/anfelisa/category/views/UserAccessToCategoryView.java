package com.anfelisa.category.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.InviteUserData;
import com.anfelisa.category.data.RevokeUserData;
import com.anfelisa.category.models.UserAccessToCategoryModel;

@SuppressWarnings("all")
public class UserAccessToCategoryView {

	private IDaoProvider daoProvider;

	public UserAccessToCategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<CategoryCreationData, Handle> grantAccess = (dataContainer, handle) -> {
		daoProvider.getUserAccessToCategoryDao().insert(handle, dataContainer);
	};

	public BiConsumer<InviteUserData, Handle> grantAccessInvitation = (dataContainer, handle) -> {
		daoProvider.getUserAccessToCategoryDao().insert(handle,
				new UserAccessToCategoryModel(dataContainer.getRootCategoryId(), dataContainer.getInvitedUserId()));
	};

	public BiConsumer<RevokeUserData, Handle> revokeAccess = (dataContainer, handle) -> {
		daoProvider.getUserAccessToCategoryDao().deleteByCategoryIdAndUserId(handle, dataContainer.getRootCategoryId(), dataContainer.getRevokedUserId());
	};
	
}

/* S.D.G. */
