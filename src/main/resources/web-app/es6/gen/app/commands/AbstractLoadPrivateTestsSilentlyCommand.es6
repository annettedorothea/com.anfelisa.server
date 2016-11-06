'use strict';

class AbstractLoadPrivateTestsSilentlyCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateTestsSilentlyCommand");
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
        this.privateTestsSilentlyLoaded = "privateTestsSilentlyLoaded";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.userNotLoggedIn:
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
        case this.privateTestsSilentlyLoaded:
        	promises.push(new PrivateTestsSilentlyLoadedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
