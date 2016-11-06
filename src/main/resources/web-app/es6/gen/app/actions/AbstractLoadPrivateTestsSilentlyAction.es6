'use strict';

class AbstractLoadPrivateTestsSilentlyAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateTestsSilentlyAction');
    }

	getCommand() {
		return new LoadPrivateTestsSilentlyCommand(this.actionData);
	}

}

/*       S.D.G.       */
