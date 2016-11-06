'use strict';

class AbstractLoadPublicLessonsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPublicLessonsAction');
    }

	getCommand() {
		return new LoadPublicLessonsCommand(this.actionData);
	}

}

/*       S.D.G.       */
