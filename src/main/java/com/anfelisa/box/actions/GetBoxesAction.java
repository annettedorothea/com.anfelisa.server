package com.anfelisa.box.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.models.IBoxViewModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class GetBoxesAction extends AbstractGetBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetBoxesAction.class);

	public GetBoxesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider, E2E e2e) {
		super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
	}

	@Override
	protected final void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
		List<IBoxViewModel> boxList = this.daoProvider.getBoxDao().selectByUserId(readonlyHandle,
				this.actionData.getUserId(), actionData.getTodayAtMidnightInUTC());
		this.actionData.setBoxList(boxList);
	}

	@Override
	public void initActionData() {
	}

}

/* S.D.G. */
