'use strict';

class GoOnWithTodaysNextCardCommand extends AbstractGoOnWithTodaysNextCardCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.outcome = this.goOnWithTodaysCards;
            resolve();
        });
    }
}

/*       S.D.G.       */
