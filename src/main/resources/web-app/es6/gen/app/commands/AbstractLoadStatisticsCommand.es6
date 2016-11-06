'use strict';

class AbstractLoadStatisticsCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadStatisticsCommand");
        this.statisticsLoaded = "statisticsLoaded";
        this.userNotLoggedIn = "userNotLoggedIn";
        this.serverError = "serverError";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.statisticsLoaded:
        	promises.push(new StatisticsLoadedEvent(this.commandData).publish());
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
