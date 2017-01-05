'use strict';

class AbstractAddCardsToBoxAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'AddCardsToBoxAction');
    }

	getCommand() {
		return new AddCardsToBoxCommand(this.actionData);
	}

}

/*       S.D.G.       */
