'use strict';

class AbstractLoadNextCardAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadNextCardAction');
    }

	getCommand() {
		return new LoadNextCardCommand(this.actionData);
	}

}

/*       S.D.G.       */
