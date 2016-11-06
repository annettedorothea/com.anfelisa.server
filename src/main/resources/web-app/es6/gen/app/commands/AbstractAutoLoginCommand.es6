'use strict';

class AbstractAutoLoginCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "AutoLoginCommand");
        this.successfulAutoLogin = "successfulAutoLogin";
        this.autoLoginFailed = "autoLoginFailed";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.successfulAutoLogin:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	break;
        case this.autoLoginFailed:
        	promises.push(new LoginFailedEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
