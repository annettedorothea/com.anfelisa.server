/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.actions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.NonDeterministicDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.commands.RegisterUserCommand;

@SuppressWarnings("unused")
public abstract class AbstractRegisterUserAction extends WriteAction<IUserRegistrationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserAction.class);
	
	public AbstractRegisterUserAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.RegisterUserAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFromNonDeterministicDataProvider() {
		LocalDateTime systemTime = NonDeterministicDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		}
		Object tokenObject = NonDeterministicDataProvider.consumeValue(this.actionData.getUuid(), "token");
		if (tokenObject != null) {
			try {
				String token = (String)tokenObject;
				this.actionData.setToken(token);
			} catch (Exception x) {
				LOG.warn("token is declared as non-deterministnic and failed to parse {} from NonDeterministicDataProvider.", tokenObject);
			}
		} else {
			LOG.warn("token is declared as non-deterministnic but no value was found in NonDeterministicDataProvider.");
		}
	}

}




/******* S.D.G. *******/



