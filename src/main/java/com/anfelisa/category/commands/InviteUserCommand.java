package com.anfelisa.category.commands;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.category.data.InviteUserData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUserModel;

public class InviteUserCommand extends AbstractInviteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(InviteUserCommand.class);

	public InviteUserCommand(InviteUserData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("Category does not exist");
		}
		IUserAccessToCategoryModel access = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), commandData.getUserId());
		if (access == null) {
			throwUnauthorized();
		}
		IUserModel invitedUser = this.daoProvider.getUserDao().selectByUsername(getHandle(),  commandData.getUsername());
		if (invitedUser == null) {
			throwBadRequest("User does not exist");
		}
		this.commandData.setInvitedUserId(invitedUser.getUserId());
		this.commandData.setRootCategoryId(category.getRootCategoryId());
		IUserAccessToCategoryModel hasAccess = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryIdAndUserId(getHandle(), category.getRootCategoryId(), invitedUser.getUserId());
		if (hasAccess == null) {
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(InviteUserCommand.hasAccess);
		}
	}

}

/*       S.D.G.       */
