'use strict';

class AbstractLoadPrivateCoursesCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPrivateCoursesCommand");
        this.privateCoursesLoaded = "privateCoursesLoaded";
        this.serverError = "serverError";
        this.userNotLoggedIn = "userNotLoggedIn";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.privateCoursesLoaded:
        	promises.push(new PrivateCoursesLoadedEvent(this.commandData).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
        case this.userNotLoggedIn:
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
