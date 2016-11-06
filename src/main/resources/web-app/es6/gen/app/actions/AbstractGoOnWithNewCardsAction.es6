'use strict';

class AbstractGoOnWithNewCardsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'GoOnWithNewCardsAction');
    }

	getCommand() {
		return new GoOnWithNewCardsCommand(this.actionData);
	}

}

/*       S.D.G.       */
