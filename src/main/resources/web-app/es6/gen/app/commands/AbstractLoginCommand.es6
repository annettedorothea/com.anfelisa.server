'use strict';

class AbstractLoginCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoginCommand");
        this.successfulLogin = "successfulLogin";
        this.loginFailed = "loginFailed";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.successfulLogin:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadStatisticsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	break;
        case this.loginFailed:
        	promises.push(new LoginFailedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
