'use strict';

class AbstractLoadPrivateLessonsCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateLessonsCommand");
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
        this.privateLessonsLoaded = "privateLessonsLoaded";
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
        case this.privateLessonsLoaded:
        	promises.push(new PrivateLessonsLoadedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
