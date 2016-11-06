'use strict';

class AbstractLoadPublicTestsCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPublicTestsCommand");
        this.publicTestsLoaded = "publicTestsLoaded";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.publicTestsLoaded:
        	promises.push(new PublicTestsLoadedEvent(this.commandData).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
