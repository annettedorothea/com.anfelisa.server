/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.actions;

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
import de.acegen.SquishyDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import com.anfelisa.box.data.IInitMyBoxesDataData;
import com.anfelisa.box.data.InitMyBoxesDataData;
import com.anfelisa.box.commands.InitMyBoxesForDayCommand;

@SuppressWarnings("unused")
public abstract class AbstractInitMyBoxesForDayAction extends WriteAction<IInitMyBoxesDataData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractInitMyBoxesForDayAction.class);
	
	public AbstractInitMyBoxesForDayAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.InitMyBoxesForDayAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider);
	}

	@Override
	public ICommand<IInitMyBoxesDataData> getCommand() {
		return new InitMyBoxesForDayCommand(daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected IInitMyBoxesDataData initActionDataFromSquishyDataProvider(IInitMyBoxesDataData data) {
		LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());
		if (systemTime != null) {
			data.setSystemTime(systemTime);
		}
		return data;
	}

	public IInitMyBoxesDataData initActionData(IInitMyBoxesDataData data) {
		return data;
	}

}




/******* S.D.G. *******/



