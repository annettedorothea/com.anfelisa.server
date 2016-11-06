'use strict';

class AbstractStartBoxAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'StartBoxAction');
    }

	getCommand() {
		return new StartBoxCommand(this.actionData);
	}

}

/*       S.D.G.       */
