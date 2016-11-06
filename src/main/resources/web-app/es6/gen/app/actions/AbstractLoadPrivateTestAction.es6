'use strict';

class AbstractLoadPrivateTestAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateTestAction');
    }

	getCommand() {
		return new LoadPrivateTestCommand(this.actionData);
	}

}

/*       S.D.G.       */
