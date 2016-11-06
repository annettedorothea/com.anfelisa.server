'use strict';

class AbstractAutoLoginAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'AutoLoginAction');
    }

	getCommand() {
		return new AutoLoginCommand(this.actionData);
	}

}

/*       S.D.G.       */
