'use strict';

class AbstractReadLastResultIdCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "ReadLastResultIdCommand");
        this.resultIdRead = "resultIdRead";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.resultIdRead:
        	promises.push(new TriggerAction(new RouteAction(this.commandData)).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
