'use strict';

class AbstractLoadPublicCoursesCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadPublicCoursesCommand");
        this.publicCoursesLoaded = "publicCoursesLoaded";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.publicCoursesLoaded:
        	promises.push(new PublicCoursesLoadedEvent(this.commandData).publish());
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
