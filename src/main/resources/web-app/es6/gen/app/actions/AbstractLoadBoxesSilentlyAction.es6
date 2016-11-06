'use strict';

class AbstractLoadBoxesSilentlyAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadBoxesSilentlyAction');
    }

	getCommand() {
		return new LoadBoxesSilentlyCommand(this.actionData);
	}

}

/*       S.D.G.       */
