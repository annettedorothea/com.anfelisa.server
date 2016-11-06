'use strict';

class AbstractScoreCardCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "ScoreCardCommand");
        this.cardScored = "cardScored";
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.cardScored:
        	promises.push(new CardScoredEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadNextCardAction(this.commandData)).publish());
        	break;
        case this.userNotLoggedIn:
        	promises.push(new TriggerAction(new LogoutAction(this.commandData)).publish());
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
