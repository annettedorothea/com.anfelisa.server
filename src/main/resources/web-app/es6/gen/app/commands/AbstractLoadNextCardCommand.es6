'use strict';

class AbstractLoadNextCardCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadNextCardCommand");
        this.nextCardLoaded = "nextCardLoaded";
        this.serverError = "serverError";
        this.userNotLoggedIn = "userNotLoggedIn";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.nextCardLoaded:
        	promises.push(new NextCardLoadedEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadPrivateCoursesSilentlyAction(this.commandData)).publish());
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
