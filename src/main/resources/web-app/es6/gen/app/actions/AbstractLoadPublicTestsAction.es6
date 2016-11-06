'use strict';

class AbstractLoadPublicTestsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPublicTestsAction');
    }

	getCommand() {
		return new LoadPublicTestsCommand(this.actionData);
	}

}

/*       S.D.G.       */
