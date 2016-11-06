'use strict';

class AbstractLoadPublicCoursesAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadPublicCoursesAction');
    }

	getCommand() {
		return new LoadPublicCoursesCommand(this.actionData);
	}

}

/*       S.D.G.       */
