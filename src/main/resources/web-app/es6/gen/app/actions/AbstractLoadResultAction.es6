'use strict';

class AbstractLoadResultAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadResultAction');
    }

	getCommand() {
		return new LoadResultCommand(this.actionData);
	}

}

/*       S.D.G.       */
