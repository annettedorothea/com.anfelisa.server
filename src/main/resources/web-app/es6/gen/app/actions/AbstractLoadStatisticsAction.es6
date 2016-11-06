'use strict';

class AbstractLoadStatisticsAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'LoadStatisticsAction');
    }

	getCommand() {
		return new LoadStatisticsCommand(this.actionData);
	}

}

/*       S.D.G.       */
