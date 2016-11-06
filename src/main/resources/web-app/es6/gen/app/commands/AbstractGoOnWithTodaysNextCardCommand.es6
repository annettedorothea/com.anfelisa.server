'use strict';

class AbstractGoOnWithTodaysNextCardCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "GoOnWithTodaysNextCardCommand");
        this.goOnWithTodaysCards = "goOnWithTodaysCards";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.goOnWithTodaysCards:
        	promises.push(new TriggerAction(new IsBoxFinishedAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
