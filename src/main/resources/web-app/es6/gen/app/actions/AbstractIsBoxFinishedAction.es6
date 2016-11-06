'use strict';

class AbstractIsBoxFinishedAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'IsBoxFinishedAction');
    }

	getCommand() {
		return new IsBoxFinishedCommand(this.actionData);
	}

}

/*       S.D.G.       */
