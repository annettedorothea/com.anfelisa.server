'use strict';

class AbstractLoadPrivateCoursesAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPrivateCoursesAction');
    }

	getCommand() {
		return new LoadPrivateCoursesCommand(this.actionData);
	}

}

/*       S.D.G.       */
