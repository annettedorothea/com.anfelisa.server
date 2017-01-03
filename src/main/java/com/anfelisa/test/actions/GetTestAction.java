package com.anfelisa.test.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestCreationData;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;

public class GetTestAction extends AbstractGetTestAction {

	static final Logger LOG = LoggerFactory.getLogger(GetTestAction.class);

	public GetTestAction(TestCreationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
		ITestModel test = TestDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getTestId(), this.actionData.getSchema());
		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setLessonId(test.getLessonId());
		this.actionData.setName(test.getName());
		this.actionData.setSequence(test.getSequence());
	}

}

/*       S.D.G.       */
