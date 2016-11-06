'use strict';

class AbstractLoadTestOfResultCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadTestOfResultCommand");
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
        this.testOfResultLoaded = "testOfResultLoaded";
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
        case this.testOfResultLoaded:
        	promises.push(new TestOfResultLoadedEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadResultAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
