'use strict';

class GoOnWithNewCardsCommand extends AbstractGoOnWithNewCardsCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.token = this.commandParam.token;
            this.commandData.boxId = this.commandParam.boxId;
            this.commandData.outcome = this.goOnWithNewCards;
            resolve();
        });
    }
}

/*       S.D.G.       */
