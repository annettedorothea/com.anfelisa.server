'use strict';

class AbstractLoadBoxesSilentlyCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadBoxesSilentlyCommand");
        this.boxSilentlyLoaded = "boxSilentlyLoaded";
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.boxSilentlyLoaded:
        	promises.push(new BoxesSilentlyLoadedEvent(this.commandData).publish());
        	break;
        case this.userNotLoggedIn:
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
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
