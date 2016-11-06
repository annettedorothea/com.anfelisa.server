'use strict';

class AbstractLoadTestOfResultAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadTestOfResultAction');
    }

	getCommand() {
		return new LoadTestOfResultCommand(this.actionData);
	}

}

/*       S.D.G.       */
