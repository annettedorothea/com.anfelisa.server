'use strict';

class AbstractLoadPrivateTestsCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateTestsCommand");
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
        this.privateTestsLoaded = "privateTestsLoaded";
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
        case this.privateTestsLoaded:
        	promises.push(new PrivateTestsLoadedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
