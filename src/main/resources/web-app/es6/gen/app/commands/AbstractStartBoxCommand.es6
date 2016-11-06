'use strict';

class AbstractStartBoxCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "StartBoxCommand");
        this.boxStarted = "boxStarted";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.boxStarted:
        	promises.push(new BoxStartedEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadNextCardAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
