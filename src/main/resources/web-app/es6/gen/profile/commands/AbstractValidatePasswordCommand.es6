'use strict';

class AbstractValidatePasswordCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "ValidatePasswordCommand");
        this.ok = "ok";
        this.mismatch = "mismatch";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.ok:
        	promises.push(new PasswordsOKEvent(this.commandData).publish());
        	break;
        case this.mismatch:
        	promises.push(new PasswordsMismatchEvent(this.commandData).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
