'use strict';

class AbstractLoadPrivateTestsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateTestsAction');
    }

	getCommand() {
		return new LoadPrivateTestsCommand(this.actionData);
	}

}

/*       S.D.G.       */
