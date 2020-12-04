package com.anfelisa.user.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteUserCommand extends AbstractDeleteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserCommand.class);

	public DeleteUserCommand(IDeleteUserData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(commandData.getRole())
				&& !commandData.getUsername().equals(commandData.getUsernameToBeDeleted())) {
			throwSecurityException();
		}
		IUserModel userToBeDeleted = daoProvider.getUserDao().selectByUsername(readonlyHandle,
				commandData.getUsernameToBeDeleted());
		if (userToBeDeleted == null) {
			throwIllegalArgumentException("userDoesNotExist");
		}
		if (Roles.ADMIN.equals(userToBeDeleted.getRole())) {
			if (daoProvider.getUserDao().selectAdminCount(readonlyHandle) == 1) {
				throwIllegalArgumentException("lastAdminMustNotBeDeleted");
			}
		}
		List<IBoxModel> boxesOfUser = daoProvider.getBoxDao().selectAllOfUser(readonlyHandle, userToBeDeleted.getUserId());
		List<String> boxIds = new ArrayList<>();
		List<String> rootCategoryIds = new ArrayList<>();
		for (IBoxModel box : boxesOfUser) {
			boxIds.add(box.getBoxId());
			rootCategoryIds.add(box.getCategoryId());
		}
		this.commandData.setBoxIds(boxIds);
		this.commandData.setRootCategoryIds(rootCategoryIds);
		this.commandData.setUserId(userToBeDeleted.getUserId());
		this.addOkOutcome();
	}

}

/* S.D.G. */
