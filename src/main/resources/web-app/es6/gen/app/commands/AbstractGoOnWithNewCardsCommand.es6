'use strict';

class AbstractGoOnWithNewCardsCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "GoOnWithNewCardsCommand");
        this.goOnWithNewCards = "goOnWithNewCards";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.goOnWithNewCards:
        	promises.push(new GoOnWithNewCardsEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadNextCardAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
