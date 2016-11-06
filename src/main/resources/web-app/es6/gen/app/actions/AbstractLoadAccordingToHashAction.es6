'use strict';

class AbstractLoadAccordingToHashAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadAccordingToHashAction');
    }

	getCommand() {
		return new LoadAccordingToHashCommand(this.actionData);
	}

}

/*       S.D.G.       */
