package com.anfelisa.category.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.IInviteUserData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;

public class InviteUserCommand extends AbstractInviteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(InviteUserCommand.class);

	public InviteUserCommand(IInviteUserData actionData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(readonlyHandle, 
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle,  category.getRootCategoryId(), commandData.getUserId());
		if (access == null || access.getEditable() == false) {
			throwUnauthorized();
		}
		IUserModel invitedUser = this.daoProvider.getUserDao().selectByUsername(readonlyHandle,  commandData.getInvitedUsername());
		if (invitedUser == null) {
			throwBadRequest("userDoesNotExist");
		}
		this.commandData.setInvitedUserId(invitedUser.getUserId());
		this.commandData.setRootCategoryId(category.getRootCategoryId());
		IUserAccessToCategoryModel hasAccess = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryIdAndUserId(readonlyHandle,  category.getRootCategoryId(), invitedUser.getUserId());
		if (hasAccess == null) {
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(InviteUserCommand.hasAccess);
		}
	}

}

/*       S.D.G.       */
