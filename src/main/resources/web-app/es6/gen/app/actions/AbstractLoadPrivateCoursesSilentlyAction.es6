'use strict';

class AbstractLoadPrivateCoursesSilentlyAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateCoursesSilentlyAction');
    }

	getCommand() {
		return new LoadPrivateCoursesSilentlyCommand(this.actionData);
	}

}

/*       S.D.G.       */
