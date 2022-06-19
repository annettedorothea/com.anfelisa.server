/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.actions;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IBoxListData;
import com.anfelisa.box.models.IBoxViewModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}


	@Override
	protected IBoxListData loadDataForGetRequest(IBoxListData data, PersistenceHandle readonlyHandle) {
		LocalDateTime today = data.getSystemTime().minusDays(1);
		List<IBoxViewModel> boxList = this.daoProvider.getBoxDao().selectByUserId(readonlyHandle,
				data.getUserId(), today);
		data.setBoxList(boxList);
		return data;
	}
	

}



/******* S.D.G. *******/



