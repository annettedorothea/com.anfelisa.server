package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IChangeUserRoleData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ChangeUserRoleCommand extends AbstractChangeUserRoleCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleCommand.class);

	public ChangeUserRoleCommand(IChangeUserRoleData actionData,
			IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(this.commandData.getRole())) {
			throwSecurityException();
		}
		if (!isRoleValid(this.commandData.getNewRole())) {
			throwIllegalArgumentException("invalidRole");
		}
		IUserModel user = daoProvider.getUserDao().selectByUserId(readonlyHandle, commandData.getEditedUserId());
		if (user == null) {
			throwIllegalArgumentException("userDoesNotExist");
		}
		if ("Admin".equals(user.getUsername())) {
			throwIllegalArgumentException("adminRoleMustNotBeChanged");
		}
		this.commandData.setOutcome(ok);
	}
	
	private boolean isRoleValid(String role) {
		return (role.equals(Roles.ADMIN) || role.equals(Roles.STUDENT));
	}

}

/* S.D.G. */
