'use strict';

class AbstractLoadPrivateTestCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateTestCommand");
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
        this.privateTestLoaded = "privateTestLoaded";
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
        case this.privateTestLoaded:
        	promises.push(new PrivateTestLoadedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
