'use strict';

class StartBoxCommand extends AbstractStartBoxCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.boxId = this.commandParam.boxId;
            this.commandData.token = this.commandParam.token;
            this.commandData.outcome = this.boxStarted;
            resolve();
        });
    }
}

/*       S.D.G.       */
