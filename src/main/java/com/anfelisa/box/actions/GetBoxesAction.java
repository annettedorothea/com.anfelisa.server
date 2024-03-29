/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.box.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.BoxListModel;
import com.anfelisa.box.models.BoxViewModel;
import com.anfelisa.box.utils.Deletable;

import de.acegen.CustomAppConfiguration;
import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration,
			IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	protected Data<BoxListModel> loadDataForGetRequest(Data<BoxListModel> data, PersistenceHandle readonlyHandle) {
		List<BoxViewModel> boxList = this.daoProvider.getBoxDao().selectByUserId(readonlyHandle,
				data.getModel().getUserId(), data.getModel().getTodayAtMidnightInUTC());
		for (BoxViewModel box : boxList) {
			box.setDeletable(Deletable.isBoxDeletable(daoProvider, readonlyHandle, box.getCategoryId(), box.getReverse(), data.getModel().getUserId()));
		}
		data.getModel().setBoxList(boxList);
		return data;
	}


}

/******* S.D.G. *******/
