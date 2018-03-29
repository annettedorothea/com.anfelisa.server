package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserInfoData;

public class GetUserInfoCommand extends AbstractGetUserInfoCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetUserInfoCommand.class);

	public GetUserInfoCommand(UserInfoData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetUserInfoCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */
