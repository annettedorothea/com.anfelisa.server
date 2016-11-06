'use strict';

class AbstractRepeatComplexCardCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "RepeatComplexCardCommand");
        this.repeatComplexCard = "repeatComplexCard";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.repeatComplexCard:
        	promises.push(new RepeatComplexCardEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
