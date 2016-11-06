'use strict';

class AbstractInitAppCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "InitAppCommand");
        this.autoLogin = "autoLogin";
        this.userIsNotLoggedIn = "userIsNotLoggedIn";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.autoLogin:
        	promises.push(new TriggerAction(new AutoLoginAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadAccordingToHashAction(this.commandData)).publish());
        	break;
        case this.userIsNotLoggedIn:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadAccordingToHashAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
