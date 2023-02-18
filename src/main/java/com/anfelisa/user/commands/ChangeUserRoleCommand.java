/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.models.ChangeUserRoleModel;
import com.anfelisa.user.models.UserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ChangeUserRoleCommand extends AbstractChangeUserRoleCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleCommand.class);

	public ChangeUserRoleCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected Data<ChangeUserRoleModel> executeCommand(Data<ChangeUserRoleModel> data, PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(data.getModel().getRole())) {
			throwSecurityException();
		}
		if (!isRoleValid(data.getModel().getNewRole())) {
			throwIllegalArgumentException("invalidRole");
		}
		UserModel user = daoProvider.getUserDao().selectByUserId(readonlyHandle, data.getModel().getEditedUserId());
		if (user == null) {
			throwIllegalArgumentException("userDoesNotExist");
		}
		if ("Admin".equals(user.getUsername())) {
			throwIllegalArgumentException("adminRoleMustNotBeChanged");
		}
		this.addOkOutcome(data);
		return data;
	}

	private boolean isRoleValid(String role) {
		return (role.equals(Roles.ADMIN) || role.equals(Roles.STUDENT));
	}
}

/******* S.D.G. *******/
