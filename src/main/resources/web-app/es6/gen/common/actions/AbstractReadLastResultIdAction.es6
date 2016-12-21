'use strict';

class AbstractReadLastResultIdAction extends Action {

    constructor(actionParam) {
        super(actionParam, 'ReadLastResultIdAction');
    }

	getCommand() {
		return new ReadLastResultIdCommand(this.actionData);
	}

}

/*       S.D.G.       */
