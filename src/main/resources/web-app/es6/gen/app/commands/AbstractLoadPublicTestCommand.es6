'use strict';

class AbstractLoadPublicTestCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPublicTestCommand");
        this.publicTestLoaded = "publicTestLoaded";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.publicTestLoaded:
        	promises.push(new PublicTestLoadedEvent(this.commandData).publish());
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
