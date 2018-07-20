package com.anfelisa.category.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.RevokeUserData;
import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserWithAccessModel;
import com.anfelisa.user.models.IUserModel;

public class RevokeUserAccessCommand extends AbstractRevokeUserAccessCommand {

	static final Logger LOG = LoggerFactory.getLogger(RevokeUserAccessCommand.class);

	public RevokeUserAccessCommand(RevokeUserData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		ICategoryModel category = daoProvider.getCategoryDao().selectByCategoryId(getHandle(),
				commandData.getCategoryId());
		if (category == null) {
			throwBadRequest("Category does not exist");
		}
		List<IUserWithAccessModel> accessList = this.daoProvider.getCustomUserAccessToCategoryDao().selectByCategoryId(getHandle(), category.getRootCategoryId());
		if (!containsUser(accessList, commandData.getUserId())) {
			throwUnauthorized();
		}
		if (accessList.size() == 1) {
			throwBadRequest("At least one user must have access to category.");
		}
		IUserModel revokedUser = this.daoProvider.getUserDao().selectByUserId(getHandle(),  commandData.getRevokedUserId());
		if (revokedUser == null) {
			throwBadRequest("User does not exist");
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
