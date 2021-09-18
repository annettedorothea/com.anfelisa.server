/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IBoxArchiveData;
import com.anfelisa.box.models.IBoxModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ArchiveBoxCommand extends AbstractArchiveBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(ArchiveBoxCommand.class);

	public ArchiveBoxCommand(IDaoProvider daoProvider, ViewProvider viewProvider, 
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected IBoxArchiveData executeCommand(IBoxArchiveData data, PersistenceHandle readonlyHandle) {
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, data.getBoxId());
		if (!box.getUserId().equals(data.getUserId())) {
			throwSecurityException();
		}
		this.addOkOutcome(data);
		return data;
	}

}




/******* S.D.G. *******/



