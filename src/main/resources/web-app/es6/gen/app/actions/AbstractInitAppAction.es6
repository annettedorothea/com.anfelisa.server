'use strict';

class AbstractInitAppAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'InitAppAction');
    }

	getCommand() {
		return new InitAppCommand(this.actionData);
	}

}

/*       S.D.G.       */
