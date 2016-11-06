'use strict';

class AbstractIsBoxFinishedCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "IsBoxFinishedCommand");
        this.notFinished = "notFinished";
        this.finished = "finished";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.notFinished:
        	promises.push(new RenderCardForRepetitionEvent(this.commandData).publish());
        	break;
        case this.finished:
        	promises.push(new TriggerAction(new StartBoxAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
