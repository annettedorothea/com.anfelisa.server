'use strict';

class AbstractLoadPublicTestAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPublicTestAction');
    }

	getCommand() {
		return new LoadPublicTestCommand(this.actionData);
	}

}

/*       S.D.G.       */
