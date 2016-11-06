'use strict';

class AbstractRepeatTodaysCardsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'RepeatTodaysCardsAction');
    }

	getCommand() {
		return new RepeatTodaysCardsCommand(this.actionData);
	}

}

/*       S.D.G.       */
