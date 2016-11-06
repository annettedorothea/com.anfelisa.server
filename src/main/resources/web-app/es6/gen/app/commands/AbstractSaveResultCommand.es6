'use strict';

class AbstractSaveResultCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "SaveResultCommand");
        this.resultSaved = "resultSaved";
        this.serverError = "serverError";
        this.userNotLoggedIn = "userNotLoggedIn";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.resultSaved:
        	promises.push(new ResultSavedEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadPrivateTestsSilentlyAction(this.commandData)).publish());
        	break;
        case this.serverError:
        	promises.push(new ServerErrorEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
        	break;
        case this.userNotLoggedIn:
        	promises.push(new DoNothingEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
