'use strict';

class AbstractGoOnWithTodaysNextCardAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'GoOnWithTodaysNextCardAction');
    }

	getCommand() {
		return new GoOnWithTodaysNextCardCommand(this.actionData);
	}

}

/*       S.D.G.       */
