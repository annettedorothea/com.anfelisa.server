package com.anfelisa.category.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.IRevokeUserData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserWithAccessModel;
import com.anfelisa.user.models.IUserModel;

public class RevokeUserAccessCommand extends AbstractRevokeUserAccessCommand {

	static final Logger LOG = LoggerFactory.getLogger(RevokeUserAccessCommand.class);

	public RevokeUserAccessCommand(IRevokeUserData actionData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("categoryDoesNotExist");
		}
		List<IUserWithAccessModel> accessList = this.daoProvider.getUserAccessToCategoryDao().selectByCategoryId(getHandle(), category.getRootCategoryId());
		if (!containsUser(accessList, commandData.getUserId())) {
			throwUnauthorized();
		}
		if (accessList.size() == 1) {
			throwBadRequest("atLeastOneUserMustHaveAccessToCategory");
		}
		IUserModel revokedUser = this.daoProvider.getUserDao().selectByUserId(getHandle(),  commandData.getRevokedUserId());
		if (revokedUser == null) {
			throwBadRequest("userDoesNotExist");
		}
		this.commandData.setRootCategoryId(category.getRootCategoryId());
		if (containsUser(accessList, commandData.getRevokedUserId())) {
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(RevokeUserAccessCommand.hasNoAccess);
		}
	}

	private boolean containsUser(List<IUserWithAccessModel> userAccessList, String userId) {
		for (IUserWithAccessModel userAccess : userAccessList) {
			if (userAccess.getUserId().equals(userId)) {
				return true;
			}
		}
		return false;
	}


}

/*       S.D.G.       */
