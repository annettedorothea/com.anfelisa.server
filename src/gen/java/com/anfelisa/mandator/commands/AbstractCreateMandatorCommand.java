package com.anfelisa.mandator.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DatabaseService;

import com.anfelisa.mandator.data.MandatorCreationData;

public abstract class AbstractCreateMandatorCommand extends Command<MandatorCreationData> {

	protected static final String mandatorCreated = "mandatorCreated";

	public AbstractCreateMandatorCommand(MandatorCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateMandatorCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case mandatorCreated:
			new com.anfelisa.mandator.events.MandatorCreatedEvent(this.commandData, databaseHandle).publish();
			final com.anfelisa.user.actions.RegisterUserAction action = new com.anfelisa.user.actions.RegisterUserAction(new com.anfelisa.user.data.RegistrationData(
						this.commandData.getId(),
						this.commandData.getUsername(),
						this.commandData.getPassword(),
						this.commandData.getName(),
						this.commandData.getPrename(),
						this.commandData.getEmail(),
						this.commandData.getRole(),
						this.commandData.getEmailConfirmed(),
						this.commandData.getEmailConfirmationHash(),
						this.commandData.getHost(),
						this.commandData.getPort(),
						this.commandData.getLocale()
			,			this.commandData.getUuid()
					), DatabaseService.getDatabaseHandle());
			Thread actionThread = new Thread(new Runnable() {
				public void run() {
					action.apply();
				}
			});
			actionThread.start();
			
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */
