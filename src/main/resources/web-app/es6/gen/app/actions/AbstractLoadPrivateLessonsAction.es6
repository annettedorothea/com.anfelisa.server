'use strict';

class AbstractLoadPrivateLessonsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateLessonsAction');
    }

	getCommand() {
		return new LoadPrivateLessonsCommand(this.actionData);
	}

}

/*       S.D.G.       */
